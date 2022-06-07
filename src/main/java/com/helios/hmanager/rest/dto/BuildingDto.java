package com.helios.hmanager.rest.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Data transfer object for building resource.
 *
 * @author Iliyan Venkov
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BuildingDto extends BaseDto {
  @NotBlank private String blockNo;
  @NotBlank private String city;
  @NotBlank private String district;
  @NotBlank private String street;
  @NotBlank private String streetNo;
  private int floors;
}
