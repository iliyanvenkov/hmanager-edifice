package com.helios.hmanager.service.apartment;

import com.helios.hmanager.persistence.entity.Apartment;
import com.helios.hmanager.persistence.repository.ApartmentRepository;
import com.helios.hmanager.rest.dto.ApartmentDto;
import com.helios.hmanager.service.CrudService;

/**
 * Generic interface for Apartment service.
 *
 * @author Ilyan Venkov
 */
public interface ApartmentService extends CrudService<ApartmentDto, Apartment> {

  @Override
  ApartmentRepository repository();
}
