package com.helios.hmanager.factory;

import com.helios.hmanager.rest.dto.ApartmentDto;
import com.helios.hmanager.rest.dto.BuildingDto;
import com.helios.hmanager.rest.dto.ParentRef;

/**
 * Factory for creating different test objects.
 *
 * @author Iliyan Venkov
 */
public class TestObjectFactory {

  /**
   * Generates {@link BuildingDto}.
   *
   * @return an instance of {@link BuildingDto}
   */
  public static BuildingDto createBuildingDto() {
    return BuildingDto.builder()
        .blockNo("440")
        .city("Taormina")
        .district("Sicily")
        .street("Via Nazionale")
        .streetNo("23")
        .floors(10)
        .build();
  }

  /**
   * Generates {@link ApartmentDto}.
   *
   * @return an instance of {@link ApartmentDto}
   */
  public static ApartmentDto createApartmentDto() {
    return ApartmentDto.builder()
        .id(1L)
        .apartmentNo("19")
        .commonArea(30.30f)
        .fullArea(240.44f)
        .entrance(new ParentRef(1L))
        .floor("5")
        .build();
  }
}
