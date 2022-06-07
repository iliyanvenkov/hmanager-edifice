package com.helios.hmanager.service;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

/**
 * Class generating currently logged user from session.
 *
 * @author Iliyan Venkov
 */
public class LoggedUserGenerator implements ValueGenerator<Long> {

  @Override
  public Long generateValue(final Session session, final Object owner) {
    // UserIdentity userIdentity = AuthService.currentUserInSecurityContext();
    // return Long.parseLong(ui != null ? ui.getUserId() : UserIdentity.publicUser().getUserId());
    return 1L;
  }
}
