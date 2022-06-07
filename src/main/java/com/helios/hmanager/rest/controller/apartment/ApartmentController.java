package com.helios.hmanager.rest.controller.apartment;

import com.helios.hmanager.persistence.entity.Apartment;
import com.helios.hmanager.rest.controller.CrudController;
import com.helios.hmanager.rest.dto.ApartmentDto;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface controller for {@link Apartment} resource.
 *
 * @author Iliyan Venkov
 */
@RequestMapping("/api/v1/apartment")
public interface ApartmentController extends CrudController<ApartmentDto, Apartment> {}
