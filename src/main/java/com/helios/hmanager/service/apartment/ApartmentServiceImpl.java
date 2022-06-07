package com.helios.hmanager.service.apartment;

import com.helios.hmanager.persistence.entity.Apartment;
import com.helios.hmanager.persistence.repository.ApartmentRepository;
import com.helios.hmanager.rest.dto.ApartmentDto;
import com.helios.hmanager.rest.mapper.ApartmentRequestMapper;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for handling requests coming from {@link
 * com.helios.hmanager.rest.controller.apartment.ApartmentController}.
 *
 * @author Iliyan Venkov
 */
@Service
@Transactional
@AllArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

  private final ApartmentRepository apartmentRepository;
  private final ApartmentRequestMapper apartmentRequestMapper;

  @Override
  public ResourceEntityTransformer<ApartmentDto, Apartment> resourceTransformer() {
    return apartmentRequestMapper;
  }

  @Override
  public ApartmentRepository repository() {
    return apartmentRepository;
  }
}
