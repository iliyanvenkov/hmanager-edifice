package com.helios.hmanager.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.BaseIntegrationTest;
import com.helios.hmanager.factory.HttpTestUtils;
import com.helios.hmanager.factory.TestObjectFactory;
import com.helios.hmanager.persistence.entity.Building;
import com.helios.hmanager.persistence.entity.Entrance;
import com.helios.hmanager.persistence.repository.ApartmentRepository;
import com.helios.hmanager.persistence.repository.BuildingRepository;
import com.helios.hmanager.persistence.repository.EntranceRepository;
import com.helios.hmanager.rest.dto.ApartmentDto;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.rest.dto.EntranceDto;
import com.helios.hmanager.rest.dto.ParentRef;
import com.helios.hmanager.rest.mapper.BuildingRequestMapper;
import com.helios.hmanager.rest.mapper.EntranceRequestMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Testing {@link com.helios.hmanager.rest.controller.apartment.ApartmentController}.
 *
 * @author Iliyan Venkov
 */
class ApartmentControllerTest extends BaseIntegrationTest {

  @Autowired private BuildingRequestMapper buildingRequestMapper;

  @Autowired private BuildingRepository buildingRepository;

  @Autowired private EntranceRequestMapper entranceRequestMapper;

  @Autowired private EntranceRepository entranceRepository;

  @Autowired private ApartmentRepository apartmentRepository;

  @Test
  void givenRequestApartmentDto_whenSave_shouldSuccess() {
    // Given building entity stored in database
    final BuildingDto buildingDto = TestObjectFactory.createBuildingDto();
    final Building savedBuildingEntity =
        buildingRepository.save(buildingRequestMapper.transformToEntity(buildingDto));
    assertThat(savedBuildingEntity).isNotNull();

    // Given entrance entity stored in database
    final EntranceDto entranceDto =
        EntranceDto.builder()
            .entranceNo("A3")
            .building(new ParentRef(savedBuildingEntity.getId()))
            .build();
    final Entrance savedEntranceEntity =
        entranceRepository.save(entranceRequestMapper.transformToEntity(entranceDto));
    assertThat(savedEntranceEntity).isNotNull();

    // Give apartmentDto
    final ApartmentDto requestBody = TestObjectFactory.createApartmentDto();
    requestBody.setEntrance(new ParentRef(savedEntranceEntity.getId()));

    // When send entranceDto request to REST endpoint
    final ResponseEntity<ApartmentDto> apartmentResponseEntity =
        testRestTemplate
            .withBasicAuth("user", "password")
            .postForEntity("/api/v1/apartment", requestBody, ApartmentDto.class);

    // Should create record in database and return a successful response
    assertThat(apartmentResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    final ApartmentDto responseBody = apartmentResponseEntity.getBody();
    assertThat(responseBody).isNotNull();
    assertThat(responseBody.getApartmentNo()).isEqualTo(requestBody.getApartmentNo());
    assertThat(responseBody.getFloor()).isEqualTo(requestBody.getFloor());
    assertThat(responseBody.getEntrance().getId()).isEqualTo(requestBody.getEntrance().getId());

    // Tear down and clean up database
    final ResponseEntity<Void> responseEntityDelete =
        HttpTestUtils.deleteEntityThroughEndpoint(
            "/api/v1/apartment/{id}", testRestTemplate, responseBody.getId());
    assertThat(responseEntityDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    entranceRepository.delete(savedEntranceEntity);
    buildingRepository.delete(savedBuildingEntity);
  }
}
