package com.helios.hmanager.service.building;

import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.persistence.repository.BuildingRepository;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.service.CrudService;

/**
 * Generic interface for Building service.
 *
 * @author Iliyan Venkov
 */
public interface BuildingService extends CrudService<BuildingDto, Building> {

  @Override
  BuildingRepository repository();
}
