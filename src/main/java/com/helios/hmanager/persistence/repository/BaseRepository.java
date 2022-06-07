package com.helios.hmanager.persistence.repository;

import com.helios.hmanager.persistence.entity.BaseEntity;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base repository interface.
 *
 * @param <E> the given {@link BaseEntity}
 * @param <I> the given {@link BaseEntity} unique identifier
 * @author Iliyan Venkov
 */
@NoRepositoryBean
public interface BaseRepository<E, I> extends JpaRepository<E, I>, QuerydslPredicateExecutor<E> {

  @Query("select t.id from #{#entityName} t where t.id in :ids")
  Set<Long> findExistingIds(List<I> ids);

  @Modifying
  @Query("delete from #{#entityName} e where e.id in ?1")
  void deleteByIds(List<I> ids);
}
