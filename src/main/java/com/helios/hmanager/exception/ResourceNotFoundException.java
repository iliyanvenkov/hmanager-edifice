package com.helios.hmanager.exception;

/**
 * Represents resource not found error.
 *
 * @author Iliyan Venkov
 */
public class ResourceNotFoundException extends BaseException {

  /*public ResourceNotFoundException(final Class clazz, final String... searchParams) {
    super(
        "exception.resource.not.found",
        new Object[] {
          StringUtils.capitalize(clazz.getSimpleName()),
          toMap(String.class, String.class, searchParams)
        });
  }*/

  public ResourceNotFoundException(final String... searchParams) {
    super(
        "exception.resource.not.found.generic",
        new Object[] {toMap(String.class, String.class, (Object) searchParams)});
  }
}
