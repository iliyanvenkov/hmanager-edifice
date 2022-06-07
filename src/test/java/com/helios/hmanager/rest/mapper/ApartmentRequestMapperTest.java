package com.helios.hmanager.rest.mapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.helios.hmanager.factory.TestObjectFactory;
import com.helios.hmanager.persistence.entity.Apartment;
import com.helios.hmanager.rest.dto.ApartmentDto;

class ApartmentRequestMapperTest {
  // @Test
  void givenApartmentDto_whenMapper_thenSuccess() {
    assertThat(ApartmentRequestMapper.MAPPER).isNotNull();
    final ApartmentDto apartmentDto = TestObjectFactory.createApartmentDto();
    final Apartment apartment = ApartmentRequestMapper.MAPPER.transformToEntity(apartmentDto);
    assertThat(apartment.getId()).isEqualTo(apartmentDto.getId());
    assertThat(apartment.getApartmentNo()).isEqualTo(apartmentDto.getApartmentNo());
    assertThat(apartment.getCommonArea()).isEqualTo(apartmentDto.getCommonArea());
    assertThat(apartment.getFullArea()).isEqualTo(apartmentDto.getFullArea());
    assertThat(apartment.getEntrance().getId()).isEqualTo(apartmentDto.getEntrance().getId());
  }
}
