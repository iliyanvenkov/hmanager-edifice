package com.helios.hmanager.persistence.entity;

import java.util.Objects;
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
 * Class representing an apartment in the building/edifice.
 *
 * @author Iliyan Venkov
 */
@Entity
@Table(name = "apartment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Apartment extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APARTMENT_SEQ")
  @SequenceGenerator(
      name = "APARTMENT_SEQ",
      sequenceName = "SEQUENCE_APARTMENT",
      allocationSize = 1)
  private Long id;

  @Column(name = "apartment_no", nullable = false)
  private String apartmentNo;

  @Column(name = "floor", nullable = false)
  private String floor;

  @Column(name = "full_area", nullable = false)
  private float fullArea;

  @Column(name = "common_area", nullable = false)
  private float commonArea;

  // @OneToMany private List<Owner> owners;

  @ManyToOne(fetch = FetchType.LAZY)
  private Entrance entrance;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    final Apartment apartment = (Apartment) o;
    return Float.compare(apartment.fullArea, fullArea) == 0
        && Float.compare(apartment.commonArea, commonArea) == 0
        && apartmentNo.equals(apartment.apartmentNo)
        && floor.equals(apartment.floor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), apartmentNo, floor, fullArea, commonArea);
  }
}
