package com.helios.hmanager.exception;

import lombok.Getter;

/**
 * Thrown when we compare request's id's and they are not equal.
 *
 * @author Iliyan Venkov
 */
@Getter
public class IncompatibleRequestIdException extends BaseException {

  public IncompatibleRequestIdException(final Long dtoId, final Long requestId) {
    super("exception.incompatibleRequestId", new Object[] {dtoId, requestId});
  }
}
