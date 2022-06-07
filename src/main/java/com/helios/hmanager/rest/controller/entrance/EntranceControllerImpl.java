package com.helios.hmanager.rest.controller.entrance;

import com.helios.hmanager.persistence.entity.Entrance;
import com.helios.hmanager.rest.dto.EntranceDto;
import com.helios.hmanager.service.CrudService;
import com.helios.hmanager.service.entrance.EntranceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of entrance controller.
 *
 * @author Iliyan Venkov
 */
@RestController
@AllArgsConstructor
public class EntranceControllerImpl implements EntranceController {

  private final EntranceService entranceService;

  @Override
  public CrudService<EntranceDto, Entrance> crudService() {
    return entranceService;
  }
}
