package com.helios.hmanager.rest.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.BaseIntegrationTest;
import com.helios.hmanager.factory.HttpTestUtils;
import com.helios.hmanager.factory.TestObjectFactory;
import com.helios.hmanager.rest.dto.BuildingDto;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Testing {@link com.helios.hmanager.rest.controller.building.BuildingController}.
 *
 * @author Iliyan Venkov
 */
class BuildingControllerTest extends BaseIntegrationTest {

  @Test
  // @Sql(scripts = "classpath:db/populateDB.sql")
  void givenUser_whenSave_shouldSuccess() {
    final BuildingDto requestBody = TestObjectFactory.createBuildingDto();
    final ResponseEntity<BuildingDto> buildingResponseEntity =
        testRestTemplate
            .withBasicAuth("user", "password")
            .postForEntity("/api/v1/building", requestBody, BuildingDto.class);
    assertThat(buildingResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    final BuildingDto responseBody = buildingResponseEntity.getBody();
    assertThat(responseBody).isNotNull();
    assertThat(responseBody.getBlockNo()).isEqualTo("440");

    // Tear down and clean up
    final ResponseEntity<Void> responseEntityDelete =
        HttpTestUtils.deleteEntityThroughEndpoint(
            "/api/v1/building/{id}", testRestTemplate, responseBody.getId());
    assertThat(responseEntityDelete.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }
}
