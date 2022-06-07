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
 * Class representing an entrance in a building.
 *
 * @author Iliyan Venkov
 */
@Entity
@Table(name = "entrance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrance extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTRANCE_SEQ")
  @SequenceGenerator(name = "ENTRANCE_SEQ", sequenceName = "SEQUENCE_ENTRANCE", allocationSize = 1)
  private Long id;

  @Column(name = "entrance_no", nullable = false)
  private String entranceNo;
  /*
  public void addApartment(final Apartment apartment) {
    apartments.add(apartment);
    apartment.setEntrance(this);
  }

  public void removeApartment(final Apartment apartment) {
    apartments.remove(apartment);
    apartment.setEntrance(null);
  }

  @OneToMany(mappedBy = "entrance", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Apartment> apartments;*/

  @ManyToOne(fetch = FetchType.LAZY)
  private Building building;
}
