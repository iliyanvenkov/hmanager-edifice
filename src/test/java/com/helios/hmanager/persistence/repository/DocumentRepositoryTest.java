package com.helios.hmanager.persistence.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.helios.hmanager.persistence.entity.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/** Class testing {@link com.helios.hmanager.persistence.repository.DocumentRepository}. */
@SpringBootTest
class DocumentRepositoryTest {

  @Autowired private DocumentRepository documentRepository;

  private Document document;

  @Test
  void createDocument() {
    document =
        documentRepository.save(
            Document.builder().documentType("JBF").documentNumber("63").build());
    assertThat(document.getCreated()).isNotNull();
    assertThat(document.getModified()).isNotNull();
    assertThat(document.getCreatedBy()).isEqualTo("Iliyan Venkov");
    assertThat(document.getModifiedBy()).isEqualTo("Iliyan Venkov");
  }
}
