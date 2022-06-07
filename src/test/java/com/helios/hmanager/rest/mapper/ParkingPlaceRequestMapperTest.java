package com.helios.hmanager.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.persistence.entity.ParkingPlace;
import com.helios.hmanager.rest.dto.ParkingPlaceDto;

class ParkingPlaceRequestMapperTest {

  // @Test
  void givenParkingPlaceDto_whenMapper_shouldSuccess() {
    final ParkingPlaceDto parkingPlaceDto =
        ParkingPlaceDto.builder().id(3L).parkingPlaceNo("1").area(12.18f).build();
    final ParkingPlace parkingPlace =
        ParkingPlaceRequestMapper.MAPPER.transformToEntity(parkingPlaceDto);
    assertThat(parkingPlace.getId()).isEqualTo(parkingPlaceDto.getId());
    assertThat(parkingPlace.getParkingPlaceNo()).isEqualTo(parkingPlaceDto.getParkingPlaceNo());
    assertThat(parkingPlace.getArea()).isEqualTo(parkingPlaceDto.getArea());
  }
}
