package com.helios.hmanager.rest.controller;

import com.helios.hmanager.persistence.entity.BaseEntity;
import com.helios.hmanager.rest.dto.BaseDto;
import com.helios.hmanager.service.CrudService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Generic delete controller.
 *
 * @param <D> {@link BaseDto}
 * @param <E> {@link BaseEntity}
 * @author Iliyan Venkov
 */
public interface DeleteController<D extends BaseDto, E extends BaseEntity> {

  CrudService<D, E> crudService();

  @DeleteMapping(path = "{id}")
  default ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
    crudService().deleteById(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping
  default ResponseEntity<Void> deleteAll(@RequestBody List<Long> idList) {
    crudService().deleteAll(idList);
    return ResponseEntity.noContent().build();
  }
}
