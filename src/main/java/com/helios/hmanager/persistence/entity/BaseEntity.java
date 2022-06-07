package com.helios.hmanager.persistence.entity;

import com.helios.hmanager.service.LoggedUserGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Abstract entity class.
 *
 * @author Iliyan Venkov
 */
@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

  public abstract Long getId();

  @Column(name = "create_user", updatable = false)
  @GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.INSERT)
  private Long createUser;

  @Column(name = "update_user")
  @GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.ALWAYS)
  private Long updateUser;

  @CreationTimestamp
  @Column(name = "creation_timestamp", updatable = false)
  private LocalDateTime creationTimestamp;

  @UpdateTimestamp
  @Column(name = "update_timestamp")
  private LocalDateTime updateTimestamp;
}
