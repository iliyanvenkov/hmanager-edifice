package com.helios.hmanager.rest.controller;

import com.helios.hmanager.persistence.entity.BaseEntity;
import com.helios.hmanager.rest.dto.BaseDto;
import com.helios.hmanager.service.CrudService;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Generic read controller.
 *
 * @param <D> {@link BaseDto}
 * @param <E> {@link BaseEntity}
 * @author Iliyan Venkov
 */
public interface ReadController<D extends BaseDto, E extends BaseEntity> {

  CrudService<D, E> crudService();

  @GetMapping
  default ResponseEntity<Page<D>> findAll(
      @RequestParam(value = "criteria") Optional<String> criteria,
      @QuerydslPredicate(root = BaseEntity.class) Predicate predicate,
      Pageable pageable) {
    return ResponseEntity.ok(crudService().findAll(predicate, pageable));
  }

  @GetMapping(path = "{id}")
  default ResponseEntity<D> findById(@PathVariable(name = "id") Long id) {
    return ResponseEntity.ok(crudService().findById(id));
  }

  @GetMapping(path = "/bulk")
  default ResponseEntity<List<D>> findAllIn(
      @RequestParam(value = "ids", required = true) List<Long> idList) {
    return ResponseEntity.ok(crudService().findAllIn(idList));
  }
}
