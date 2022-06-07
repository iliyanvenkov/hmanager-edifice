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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class representing an owner of an apartment or parking place.
 *
 * @author Iliyan Venkov
 */
@Entity
@Table(name = "owner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OWNER_SEQ")
  @SequenceGenerator(name = "OWNER_SEQ", sequenceName = "SEQUENCE_OWNER", allocationSize = 1)
  private Long id;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column(name = "type_owner", nullable = false)
  private String typeOwner;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "address", nullable = false)
  private String address;

  @ManyToOne(fetch = FetchType.LAZY)
  private Building building;

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
    final Owner owner = (Owner) o;
    return typeOwner.equals(owner.typeOwner)
        && phone.equals(owner.phone)
        && email.equals(owner.email)
        && address.equals(owner.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), typeOwner, phone, email, address);
  }
}
