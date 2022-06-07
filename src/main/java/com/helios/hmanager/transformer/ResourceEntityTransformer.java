package com.helios.hmanager.transformer;

import com.helios.hmanager.persistence.entity.BaseEntity;

/**
 * Generic resource entity transformer.
 *
 * @param <R> BaseDto
 * @param <E> BasicEntity
 * @author Iliyan Venkov
 */
public interface ResourceEntityTransformer<R, E> {

  R transformToResource(E entity);

  E transformToEntity(R resource);

  /**
   * This allows subclasses to use different kinds of mapping for bulk listings (findAll() etc.)
   * than for individual GET/PUT operations.
   *
   * @param entity of type {@link BaseEntity}.
   * @return {@link com.helios.hmanager.rest.dto.BaseDto} type
   */
  default R transformToResourceForListing(E entity) {
    return transformToResource(entity);
  }
}
