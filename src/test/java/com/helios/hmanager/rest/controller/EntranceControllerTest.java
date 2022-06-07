package com.helios.hmanager.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.BaseIntegrationTest;
import com.helios.hmanager.factory.HttpTestUtils;
import com.helios.hmanager.factory.TestObjectFactory;
import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.persistence.repository.BuildingRepository;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.rest.dto.EntranceDto;
import com.helios.hmanager.rest.dto.ParentRef;
import com.helios.hmanager.rest.mapper.BuildingRequestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Testing {@link com.helios.hmanager.rest.controller.entrance.EntranceController}.
 *
 * @author Iliyan Venkov
 */
class EntranceControllerTest extends BaseIntegrationTest {

  @Autowired private BuildingRequestMapper buildingRequestMapper;

  @Autowired private BuildingRepository buildingRepository;

  @Test
  void givenRequestEntrance_whenSave_shouldSuccess() {
    // Given building entity stored in database
    final BuildingDto buildingDto = TestObjectFactory.createBuildingDto();
    final Building savedBuildingEntity =
        buildingRepository.save(buildingRequestMapper.transformToEntity(buildingDto));
    assertThat(savedBuildingEntity).isNotNull();

    // Given entranceDto request
    final EntranceDto requestBody =
        EntranceDto.builder()
            .entranceNo("A3")
            .building(new ParentRef(savedBuildingEntity.getId()))
            .build();

    // When send POST entranceDto request to REST endpoint
    final ResponseEntity<EntranceDto> entranceResponseEntity =
        testRestTemplate
            .withBasicAuth("user", "password")
            .postForEntity("/api/v1/entrance", requestBody, EntranceDto.class);

    // Should create record in database and return a response
    assertThat(entranceResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    final EntranceDto responseBody = entranceResponseEntity.getBody();
    assertThat(responseBody).isNotNull();
    assertThat(responseBody.getEntranceNo()).isEqualTo("A3");
    assertThat(responseBody.getBuilding().getId()).isEqualTo(savedBuildingEntity.getId());

    // Tear down and clean up
    final ResponseEntity<Void> responseEntityDelete =
        HttpTestUtils.deleteEntityThroughEndpoint(
            "/api/v1/entrance/{id}", testRestTemplate, responseBody.getId());
    assertThat(responseEntityDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    buildingRepository.delete(savedBuildingEntity);
  }
}
