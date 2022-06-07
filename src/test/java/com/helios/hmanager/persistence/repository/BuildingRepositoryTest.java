package com.helios.hmanager.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.BaseIntegrationTest;
import com.helios.hmanager.persistence.entity.Building;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Tests building repository.
 *
 * @author Iliyan Venkov
 */
class BuildingRepositoryTest extends BaseIntegrationTest {

  @Autowired protected BuildingRepository buildingRepository;

  @Test
  @Transactional
  void injectedComponentsAreNotNull() {
    assertThat(buildingRepository).isNotNull();

    final Building building =
        Building.builder()
            .blockNo("620")
            .city("Sofia")
            .district("Sofia")
            .street("Bogdan Tomalevski")
            .streetNo("10")
            .floors(9)
            .build();
    buildingRepository.save(building);
    final List<Building> foundBuilding = buildingRepository.findBuildingByCity("Sofia");
    System.out.println(foundBuilding);
    buildingRepository.updateBuildingFloors("620");
  }
}
