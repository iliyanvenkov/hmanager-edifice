package com.helios.hmanager.rest.controller.parkingplace;

import com.helios.hmanager.persistence.entity.ParkingPlace;
import com.helios.hmanager.rest.controller.CrudController;
import com.helios.hmanager.rest.dto.ParkingPlaceDto;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface controller for {@link ParkingPlace} resource.
 *
 * @author Iliyan Venkov
 */
@RequestMapping("/api/v1/parkingplace")
public interface ParkingPlaceController extends CrudController<ParkingPlaceDto, ParkingPlace> {}
