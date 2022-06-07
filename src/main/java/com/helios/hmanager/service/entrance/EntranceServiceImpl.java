package com.helios.hmanager.service.entrance;

import com.helios.hmanager.persistence.entity.Entrance;
import com.helios.hmanager.persistence.repository.BaseRepository;
import com.helios.hmanager.persistence.repository.EntranceRepository;
import com.helios.hmanager.rest.dto.EntranceDto;
import com.helios.hmanager.rest.mapper.EntranceRequestMapper;
import com.helios.hmanager.transformer.ResourceEntityTransformer;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Entrance service implementation.
 *
 * @author Iliyan Venkov
 */
@Service
@Transactional
@AllArgsConstructor
public class EntranceServiceImpl implements EntranceService {

  private final EntranceRepository entranceRepository;
  private final EntranceRequestMapper entranceRequestMapper;

  @Override
  public BaseRepository<Entrance, Long> repository() {
    return entranceRepository;
  }

  @Override
  public ResourceEntityTransformer<EntranceDto, Entrance> resourceTransformer() {
    return entranceRequestMapper;
  }
}
