package com.helios.hmanager.rest.mapper;

import com.helios.hmanager.persistence.entity.BaseEntity;
import com.helios.hmanager.rest.dto.ParentRef;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

/**
 * Custom mapper for attaching parent entity to target entity.
 *
 * @author Iliyan Venkov
 */
@Component
public class ReferenceMapper {

  @PersistenceContext private EntityManager entityManager;

  public <T extends BaseEntity> T resolve(
      final ParentRef parentRef, @TargetType final Class<T> entityClass) {
    return parentRef != null ? entityManager.find(entityClass, parentRef.getId()) : null;
  }

  public ParentRef toParentRef(final BaseEntity entity) {
    return entity != null ? new ParentRef(entity.getId()) : null;
  }
}
