package com.helios.hmanager.rest.controller.apartment;

import com.helios.hmanager.persistence.entity.Apartment;
import com.helios.hmanager.rest.dto.ApartmentDto;
import com.helios.hmanager.service.CrudService;
import com.helios.hmanager.service.apartment.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of apartment controller.
 *
 * @author Iliyan Venkov
 */
@RestController
@AllArgsConstructor
public class ApartmentControllerImpl implements ApartmentController {

  private final ApartmentService apartmentService;

  @Override
  public CrudService<ApartmentDto, Apartment> crudService() {
    return apartmentService;
  }
}
