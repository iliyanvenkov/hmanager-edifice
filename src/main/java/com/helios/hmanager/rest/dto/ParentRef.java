package com.helios.hmanager.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Holds parent object id (parent primary key) to which current object is attached to. Represents
 * JPA unidirectional @ManyToOne entity associations.
 *
 * @author Iliyan Venkov
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class ParentRef {
  private Long id;
}
