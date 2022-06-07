package com.helios.hmanager.rest.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.BaseIntegrationTest;
import com.helios.hmanager.persistence.entity.Entrance;
import com.helios.hmanager.rest.dto.EntranceDto;
import com.helios.hmanager.rest.dto.ParentRef;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;

@TestInstance(Lifecycle.PER_CLASS)
class EntranceRequestMapperTest extends BaseIntegrationTest {

  @Autowired private ReferenceMapper referenceMapper;

  @BeforeAll
  public void init() {
    assertThat(referenceMapper).isNotNull();
    ReflectionTestUtils.setField(EntranceRequestMapper.MAPPER, "referenceMapper", referenceMapper);
  }

  // @Test
  void givenEntranceRequest_whenMapper_thenSuccess() {
    assertThat(EntranceRequestMapper.MAPPER).isNotNull();
    // Given request entrance dto
    final EntranceDto requestEntranceDto =
        EntranceDto.builder().id(2L).entranceNo("A").building(new ParentRef(1L)).build();

    // When transform to entrance entity
    final Entrance entrance = EntranceRequestMapper.MAPPER.transformToEntity(requestEntranceDto);

    // Should have successful transformation
    assertThat(entrance.getEntranceNo()).isEqualTo(requestEntranceDto.getEntranceNo());
    assertThat(entrance.getId()).isEqualTo(requestEntranceDto.getId());

    // Given database entrance entity, When transform to response entrance dto, Should success
    final EntranceDto responseEntranceDto =
        EntranceRequestMapper.MAPPER.transformToResource(entrance);
    assertThat(responseEntranceDto.getEntranceNo()).isEqualTo(entrance.getEntranceNo());
    assertThat(responseEntranceDto.getBuilding().getId()).isEqualTo(entrance.getBuilding().getId());
  }
}
