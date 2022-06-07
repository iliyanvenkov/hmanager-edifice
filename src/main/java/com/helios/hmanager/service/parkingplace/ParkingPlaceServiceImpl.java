package com.helios.hmanager.service.parkingplace;

import com.helios.hmanager.persistence.entity.ParkingPlace;
import com.helios.hmanager.persistence.repository.BaseRepository;
import com.helios.hmanager.persistence.repository.ParkingPlaceRepository;
import com.helios.hmanager.rest.dto.ParkingPlaceDto;
import com.helios.hmanager.rest.mapper.ParkingPlaceRequestMapper;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Parking place service implementation.
 *
 * @author Iliyan Venkov
 */
@Service
@Transactional
@AllArgsConstructor
public class ParkingPlaceServiceImpl implements ParkingPlaceService {

  private final ParkingPlaceRepository parkingPlaceRepository;
  private final ParkingPlaceRequestMapper parkingPlaceRequestMapper;

  @Override
  public BaseRepository<ParkingPlace, Long> repository() {
    return parkingPlaceRepository;
  }

  @Override
  public ResourceEntityTransformer<ParkingPlaceDto, ParkingPlace> resourceTransformer() {
    return parkingPlaceRequestMapper;
  }
}
