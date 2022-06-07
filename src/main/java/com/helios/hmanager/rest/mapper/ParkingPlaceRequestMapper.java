package com.helios.hmanager.rest.mapper;

import com.helios.hmanager.persistence.entity.ParkingPlace;
import com.helios.hmanager.rest.dto.ParkingPlaceDto;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for Entrance to EntranceDto object mapping and vice versa.
 *
 * @author Iliyan Venkov
 */
@Mapper(uses = ReferenceMapper.class)
public interface ParkingPlaceRequestMapper
    extends ResourceEntityTransformer<ParkingPlaceDto, ParkingPlace> {

  ParkingPlaceRequestMapper MAPPER = Mappers.getMapper(ParkingPlaceRequestMapper.class);

  @Override
  @InheritConfiguration
  ParkingPlaceDto transformToResource(ParkingPlace parkingPlace);

  @Override
  @InheritConfiguration
  ParkingPlace transformToEntity(ParkingPlaceDto parkingPlaceDto);
}
