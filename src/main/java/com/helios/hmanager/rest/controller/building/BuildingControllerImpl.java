package com.helios.hmanager.rest.controller.building;

import com.helios.hmanager.exception.ResourceNotFoundException;
import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.service.CrudService;
import com.helios.hmanager.service.building.BuildingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of building controller.
 *
 * @author Iliyan Venkov
 */
@RestController
@AllArgsConstructor
public class BuildingControllerImpl implements BuildingController {

  private final BuildingService buildingService;

  @Override
  public CrudService<BuildingDto, Building> crudService() {
    return buildingService;
  }

  @GetMapping("/info")
  public String getInfo() {
    throw new ResourceNotFoundException("This method is not implemented yet.");
  }
}
