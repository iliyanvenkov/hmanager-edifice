package com.helios.hmanager.service.building;

import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.persistence.repository.BuildingRepository;
import com.helios.hmanager.rest.controller.building.BuildingController;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.rest.mapper.BuildingRequestMapper;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for handling requests coming from {@link BuildingController}.
 *
 * @author Iliyan Venkov
 */
@Service
@Transactional
@AllArgsConstructor
public class BuildingServiceImpl implements BuildingService {

  private final BuildingRepository buildingRepository;
  private final BuildingRequestMapper buildingRequestMapper;

  @Override
  public BuildingRepository repository() {
    return buildingRepository;
  }

  @Override
  public ResourceEntityTransformer<BuildingDto, Building> resourceTransformer() {
    return buildingRequestMapper;
  }
}
