package com.helios.hmanager.config;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

/**
 * Custom audit aware implementation informing Spring who is current auditor. Fields annotated
 * with @CreatedBy and @ModifiedBy will be automatically populated if Spring Security is available
 * in the project path.
 *
 * @author Iliyan Venkov
 */
public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public Optional<String> getCurrentAuditor() {
    return Optional.of("Iliyan Venkov");
  }
}
