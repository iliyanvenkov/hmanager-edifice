package com.helios.hmanager.persistence.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing a building or edifice.
 *
 * @author Iliyan Venkov
 */
@Entity
@Table(
    name = "building",
    uniqueConstraints = @UniqueConstraint(columnNames = {"city", "district", "block_no"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUILDING_SEQ")
  @SequenceGenerator(name = "BUILDING_SEQ", sequenceName = "SEQUENCE_BUILDING", allocationSize = 1)
  private Long id;

  @Column(name = "block_no", nullable = false)
  private String blockNo;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "district", nullable = false)
  private String district;

  @Column(name = "street", nullable = false)
  private String street;

  @Column(name = "street_no", nullable = false)
  private String streetNo;

  @Column(name = "floors", nullable = false)
  private int floors;

  /*
  public void addEntrance(final Entrance entrance) {
    entrances.add(entrance);
    entrance.setBuilding(this);
  }

  public void removeEntrance(final Entrance entrance) {
    entrances.remove(entrance);
    entrance.setBuilding(null);
  }
  public void addParkingPlace(final ParkingPlace parkingPlace) {
    parkingPlaces.add(parkingPlace);
    parkingPlace.setBuilding(this);
  }

  public void removeParkingPlace(final ParkingPlace parkingPlace) {
    parkingPlaces.remove(parkingPlace);
    parkingPlace.setBuilding(null);
  }

  @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Entrance> entrances;

  @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ParkingPlace> parkingPlaces;*/

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
    final Building building = (Building) o;
    return blockNo.equals(building.blockNo)
        && city.equals(building.city)
        && district.equals(building.district)
        && street.equals(building.street)
        && streetNo.equals(building.streetNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), blockNo, city, district, street, streetNo);
  }
}
