package com.helios.hmanager.rest.mapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.rest.dto.BuildingDto;

class BuildingRequestMapperTest {

  // @Test
  void givenBuildingDto_whenMapper_thenSuccess() {
    assertThat(BuildingRequestMapper.MAPPER).isNotNull();
    final BuildingDto buildingDto =
        BuildingDto.builder()
            .id(1L)
            .blockNo("620")
            .city("Taurmina")
            .district("Venice")
            .street("Some street")
            .streetNo("230")
            .floors(10)
            .build();
    final Building building = BuildingRequestMapper.MAPPER.transformToEntity(buildingDto);
    assertThat(building.getId()).isEqualTo(buildingDto.getId());
    assertThat(building.getBlockNo()).isEqualTo(buildingDto.getBlockNo());
    assertThat(building.getCity()).isEqualTo(buildingDto.getCity());
    assertThat(building.getDistrict()).isEqualTo(buildingDto.getDistrict());
    assertThat(building.getStreet()).isEqualTo(buildingDto.getStreet());
    assertThat(building.getStreetNo()).isEqualTo(buildingDto.getStreetNo());
    assertThat(building.getFloors()).isEqualTo(buildingDto.getFloors());
  }
}
