package com.helios.hmanager.rest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class EntranceDto extends BaseDto {
  @NotBlank private String entranceNo;
  @NotNull private ParentRef building;
}
