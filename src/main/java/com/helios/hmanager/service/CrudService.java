package com.helios.hmanager.service;

import com.helios.hmanager.exception.ResourceNotFoundException;
import com.helios.hmanager.persistence.entity.BaseEntity;
import com.helios.hmanager.persistence.repository.BaseRepository;
import com.helios.hmanager.rest.dto.BaseDto;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Generic CRUD service.
 *
 * @param <D> {@link BaseDto}
 * @param <E> {@link BaseEntity}
 * @author Iliyan Venkov
 */
public interface CrudService<D extends BaseDto, E extends BaseEntity> {

  BaseRepository<E, Long> repository();

  ResourceEntityTransformer<D, E> resourceTransformer();

  default D save(final D dto) {
    return resourceTransformer()
        .transformToResource(repository().save(resourceTransformer().transformToEntity(dto)));
  }

  /**
   * Save and flush Persistence context.
   *
   * @param dto BaseDto
   * @return BaseDto
   */
  default D saveAndFlush(final D dto) {
    final Optional<E> entityOpt = repository().findById(dto.getId());
    if (entityOpt.isEmpty()) {
      throw new ResourceNotFoundException("id", dto.getId().toString());
    }

    final E entity = entityOpt.get();

    dto.setCreateUser(entity.getCreateUser());
    if (entity.getCreationTimestamp() != null) {
      dto.setCreationTimestamp(entity.getCreationTimestamp());
    }
    return resourceTransformer().transformToResource(saveAndFlushEntity(dto));
  }

  default E saveAndFlushEntity(D dto) {
    return repository().saveAndFlush(resourceTransformer().transformToEntity(dto));
  }

  /**
   * Find an entity by id.
   *
   * @param id of the entity
   * @return BaseDto
   */
  default D findById(final Long id) {
    final E entity =
        repository()
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("id", id.toString()));
    return resourceTransformer().transformToResource(entity);
  }

  /**
   * Return all entities from database based on predicate.
   *
   * @param predicate attribute
   * @param pageable attribute
   * @return Page of BaseDto
   */
  default Page<D> findAll(Predicate predicate, Pageable pageable) {
    final ResourceEntityTransformer<D, E> transformer = resourceTransformer();
    final Page<E> page = repository().findAll(predicate, pageable);
    final List<D> result =
        page.stream().map(transformer::transformToResourceForListing).collect(Collectors.toList());
    return new PageImpl<>(result, pageable, page.getTotalElements());
  }

  /**
   * Return all entities by list of ID's.
   *
   * @param idList List of entity's ID's
   * @return BaseDto list of objects
   */
  default List<D> findAllIn(List<Long> idList) {
    final ResourceEntityTransformer<D, E> transformer = resourceTransformer();
    return findAllById(idList).stream()
        .map(transformer::transformToResourceForListing)
        .collect(Collectors.toList());
  }

  default List<E> findAllById(List<Long> idList) {
    return repository().findAllById(idList);
  }

  default void deleteById(Long id) {
    repository().deleteById(id);
  }

  /**
   * List of BaseDto objects.
   *
   * @param dtoList List of BaseDto ID's.
   * @return List of BaseDto objects.
   */
  default List<D> editAll(List<D> dtoList) {
    final Set<Long> ids =
        repository()
            .findExistingIds(dtoList.stream().map(dto -> dto.getId()).collect(Collectors.toList()));
    return saveAll(
        dtoList.stream().filter(dto -> ids.contains(dto.getId())).collect(Collectors.toList()));
  }

  @Transactional
  default void deleteAll(List<Long> idList) {
    repository().deleteByIds(idList);
  }

  /**
   * Save a list of BaseDto objects.
   *
   * @param dtoList List of Dto ID's
   * @return List of equivalent BasicEntity objects.
   */
  default List<D> saveAll(List<D> dtoList) {
    return repository()
        .saveAll(
            dtoList.stream()
                .map(dto -> resourceTransformer().transformToEntity(dto))
                .collect(Collectors.toList()))
        .stream()
        .map(e -> resourceTransformer().transformToResource(e))
        .collect(Collectors.toList());
  }
}
