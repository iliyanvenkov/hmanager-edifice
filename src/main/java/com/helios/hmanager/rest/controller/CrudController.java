package com.helios.hmanager.rest.controller;

import static org.springframework.http.HttpStatus.CREATED;

import com.helios.hmanager.persistence.entity.BaseEntity;
import com.helios.hmanager.rest.dto.BaseDto;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Implement basic save mappings.
 *
 * @param <D> {@link BaseDto}
 * @param <E> {@link BaseEntity}
 */
@Validated
public interface CrudController<D extends BaseDto, E extends BaseEntity>
    extends ReadController<D, E>, EditController<D, E>, DeleteController<D, E> {

  @PostMapping()
  default ResponseEntity<D> save(@Valid @RequestBody D dto) {
    return ResponseEntity.status(CREATED).body(crudService().save(dto));
  }

  @PostMapping("/bulk")
  default ResponseEntity<List<D>> saveAll(@RequestBody List<@Valid D> dtoList) {
    return ResponseEntity.status(CREATED).body(crudService().saveAll(dtoList));
  }
}
