package com.helios.hmanager.rest.mapper;

import com.helios.hmanager.persistence.entity.Apartment;
import com.helios.hmanager.rest.dto.ApartmentDto;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * MapStruct mapper for {@link Apartment} to {@link ApartmentDto} object mapping and vice versa.
 *
 * @author Iliyan Venkov
 */
@Mapper(uses = ReferenceMapper.class)
public interface ApartmentRequestMapper extends ResourceEntityTransformer<ApartmentDto, Apartment> {

  ApartmentRequestMapper MAPPER = Mappers.getMapper(ApartmentRequestMapper.class);

  @Override
  @InheritConfiguration
  ApartmentDto transformToResource(Apartment entity);

  @Override
  @InheritConfiguration
  Apartment transformToEntity(ApartmentDto resource);
}
