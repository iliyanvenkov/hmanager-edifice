package com.helios.hmanager.rest.controller.building;

import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.rest.controller.CrudController;
import com.helios.hmanager.rest.dto.BuildingDto;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface controller for {@link Building} resource.
 *
 * @author Iliyan Venkov
 */
@RequestMapping("/api/v1/building")
public interface BuildingController extends CrudController<BuildingDto, Building> {}
