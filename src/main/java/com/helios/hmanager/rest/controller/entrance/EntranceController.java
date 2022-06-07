package com.helios.hmanager.rest.controller.entrance;

import com.helios.hmanager.persistence.entity.Entrance;
import com.helios.hmanager.rest.controller.CrudController;
import com.helios.hmanager.rest.dto.EntranceDto;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface controller for {@link Entrance} resource.
 *
 * @author Iliyan Venkov
 */
@RequestMapping("/api/v1/entrance")
public interface EntranceController extends CrudController<EntranceDto, Entrance> {}
