package com.helios.hmanager.persistence.repository;

import com.helios.hmanager.persistence.entity.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Document repository for processing {@link Document} entities.
 *
 * @author Iliyan Venkov
 */
@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {}
