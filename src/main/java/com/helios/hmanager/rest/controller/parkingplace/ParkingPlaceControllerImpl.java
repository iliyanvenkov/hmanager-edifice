package com.helios.hmanager.rest.controller.parkingplace;

import com.helios.hmanager.persistence.entity.ParkingPlace;
import com.helios.hmanager.rest.dto.ParkingPlaceDto;
import com.helios.hmanager.service.CrudService;
import com.helios.hmanager.service.parkingplace.ParkingPlaceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of parking place controller.
 *
 * @author Iliyan Venkov
 */
@RestController
@AllArgsConstructor
public class ParkingPlaceControllerImpl implements ParkingPlaceController {

  private final ParkingPlaceService parkingPlaceService;

  @Override
  public CrudService<ParkingPlaceDto, ParkingPlace> crudService() {
    return parkingPlaceService;
  }
}
