package com.helios.hmanager.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler for exceptions thrown in controllers.
 *
 * @author Iliyan Venkov
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  public ResponseEntity<Object> handleIllegalArgumentException(
      final IllegalArgumentException exception, final WebRequest request) {
    log.error("Method not allowed: {}", exception.getMessage());
    return buildErrorResponse(exception, HttpStatus.METHOD_NOT_ALLOWED, request);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> handleAllUncaughtException(
      final Exception exception, final WebRequest request) {
    log.error("Unknown error occurred: {}", exception.getMessage());
    return buildErrorResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR, request);
  }

  @Override
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      final MethodArgumentNotValidException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {
    final ErrorResponse errorResponse =
        ErrorResponse.builder()
            .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
            .message("Validation error. Check errors field for details.")
            .build();
    for (final FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
      errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
    }
    return ResponseEntity.unprocessableEntity().body(errorResponse);
  }

  /**
   * All the handlers in the ResponseEntityExceptionHandler use this function to build the
   * ResponseEntity similar to our buildErrorResponse(). If we don’t override this then the clients
   * will receive only the HTTP status in the response header but since we want to include the HTTP
   * status in our response bodies as well, we have overridden the method.
   *
   * @param ex
   * @param body
   * @param headers
   * @param status
   * @param request
   * @return
   */
  @Override
  public ResponseEntity<Object> handleExceptionInternal(
      final Exception ex,
      final Object body,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {
    return buildErrorResponse(ex, status, request);
  }

  private ResponseEntity<Object> buildErrorResponse(
      final Exception exception, final HttpStatus httpStatus, final WebRequest request) {
    final ErrorResponse errorResponse =
        ErrorResponse.builder().status(httpStatus.value()).message(exception.getMessage()).build();
    return ResponseEntity.status(httpStatus).body(errorResponse);
  }
}
