package com.helios.hmanager.rest.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/** Handling data transfer object from request. */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ParkingPlaceDto extends BaseDto {
  @NotBlank private String parkingPlaceNo;
  private float area;
  private ParentRef building;
}
