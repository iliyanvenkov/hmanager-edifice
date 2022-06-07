package com.helios.hmanager.rest.controller;

import com.helios.hmanager.persistence.entity.BaseEntity;
import com.helios.hmanager.rest.dto.BaseDto;
import com.helios.hmanager.rest.validation.RequestPathDtoIdValidationHelper;
import com.helios.hmanager.service.CrudService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Generic controller for edit operations.
 *
 * @param <D> {@link BaseDto}
 * @param <E> {@link BaseEntity}
 */
public interface EditController<D extends BaseDto, E extends BaseEntity> {
  CrudService<D, E> crudService();

  @PutMapping(path = "{id}")
  default ResponseEntity<D> edit(@PathVariable(name = "id") Long id, @Valid @RequestBody D dto) {
    RequestPathDtoIdValidationHelper.idPreUpdateValidate(dto.getId(), id);
    return ResponseEntity.ok(crudService().saveAndFlush(dto));
  }

  @PutMapping("/bulk")
  default ResponseEntity<List<D>> editAll(@RequestBody List<@Valid D> dtoList) {
    return ResponseEntity.ok(crudService().editAll(dtoList));
  }
}
