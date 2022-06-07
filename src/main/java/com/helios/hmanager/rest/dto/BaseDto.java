package com.helios.hmanager.rest.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Basic class of all Dto types.
 *
 * @author Iliyan Venkov
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BaseDto {
  private Long id;
  private Long createUser;
  private Long updateUser;
  private LocalDateTime creationTimestamp;
  private LocalDateTime updateTimestamp;
}
