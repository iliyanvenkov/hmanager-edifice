package com.helios.hmanager.rest.validation;

import com.helios.hmanager.exception.IncompatibleRequestIdException;
import java.util.Objects;

/**
 * Validation helper of request ID's.
 *
 * @author Iliyan Venkov
 */
public class RequestPathDtoIdValidationHelper {
  public RequestPathDtoIdValidationHelper() {
    throw new UnsupportedOperationException();
  }

  /**
   * Validate whether object id and request id are the same.
   *
   * @param dtoId Object id
   * @param requestId Request id
   */
  public static void idPreUpdateValidate(final Long dtoId, final Long requestId) {
    if (!Objects.equals(dtoId, requestId)) {
      throw new IncompatibleRequestIdException(dtoId, requestId);
    }
  }
}
