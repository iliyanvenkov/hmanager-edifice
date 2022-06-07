package com.helios.hmanager.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing parking place in the building.
 *
 * @author Iliyan Venkov
 */
@Entity
@Table(name = "parking_place")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingPlace extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARKING_PLACE_SEQ")
  @SequenceGenerator(
      name = "PARKING_PLACE_SEQ",
      sequenceName = "SEQUENCE_PARKING_PLACE",
      allocationSize = 1)
  private Long id;

  @Column(name = "parking_place_no")
  private String parkingPlaceNo;

  @Column(name = "area")
  private float area;

  // @OneToOne private Owner owner;

  @ManyToOne(fetch = FetchType.LAZY)
  private Building building;
}
