package com.helios.hmanager.persistence.repository;

import com.helios.hmanager.persistence.entity.Building;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Building repository for processing {@link Building} entities.
 *
 * @author Iliyan Venkov
 */
@Repository
public interface BuildingRepository extends BaseRepository<Building, Long> {

  /**
   * Query method.
   *
   * @param district Given district
   * @return List of building in the given district
   */
  List<Building> findByDistrict(final String district);

  @Query("select b from Building b where b.city = :city")
  List<Building> findBuildingByCity(@Param("city") final String city);

  @Modifying(flushAutomatically = true, clearAutomatically = true)
  @Query("update Building b set b.floors = 1 where b.blockNo = :blockNo")
  void updateBuildingFloors(@Param("blockNo") final String blockNo);
}
