package com.helios.hmanager.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Sample entity with Spring Data Auditing configuration.
 *
 * @author Iliyan Venkov
 */
@Entity
@Table(name = "document")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Audited
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOCUMENT_SEQ")
  @SequenceGenerator(name = "DOCUMENT_SEQ", sequenceName = "SEQUENCE_DOCUMENT", allocationSize = 1)
  private Long id;

  @Column(name = "document_type", nullable = false)
  private String documentType;

  @Column(name = "document_num", nullable = false)
  private String documentNumber;

  @CreatedBy
  @Column(name = "created_by", nullable = false)
  private String createdBy;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime created;

  @LastModifiedBy
  @Column(name = "modified_by", nullable = false)
  private String modifiedBy;

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime modified;
}
