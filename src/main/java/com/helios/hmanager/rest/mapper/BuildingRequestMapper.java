package com.helios.hmanager.rest.mapper;

import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for Building to BuildingDto object mapping and vice versa.
 *
 * @author Iliyan Venkov
 */
@Mapper
public interface BuildingRequestMapper extends ResourceEntityTransformer<BuildingDto, Building> {

  BuildingRequestMapper MAPPER = Mappers.getMapper(BuildingRequestMapper.class);

  @Override
  @InheritConfiguration
  BuildingDto transformToResource(Building building);

  @Override
  @InheritConfiguration
  Building transformToEntity(BuildingDto buildingDto);
}
