package com.helios.hmanager.rest.mapper;

import com.helios.hmanager.persistence.entity.Entrance;
import com.helios.hmanager.rest.dto.EntranceDto;
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
public interface EntranceRequestMapper extends ResourceEntityTransformer<EntranceDto, Entrance> {

  EntranceRequestMapper MAPPER = Mappers.getMapper(EntranceRequestMapper.class);

  @Override
  @InheritConfiguration
  // @Mapping(target = "building", ignore = true)
  EntranceDto transformToResource(Entrance entrance);

  @Override
  @InheritConfiguration
  Entrance transformToEntity(EntranceDto entranceDto);
}
