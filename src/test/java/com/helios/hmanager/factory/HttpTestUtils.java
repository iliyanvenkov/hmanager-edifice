package com.helios.hmanager.factory;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * Helper class with methods for different HTTP operations.
 *
 * @author Iliyan Venkov
 */
public class HttpTestUtils {

  /**
   * Sends DELETE request for particular resource.
   *
   * @param url given String url
   * @param testRestTemplate given {@link TestRestTemplate}
   * @param id given id
   * @return a {@link ResponseEntity}
   */
  public static ResponseEntity<Void> deleteEntityThroughEndpoint(
      final String url, final TestRestTemplate testRestTemplate, final Long id) {
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    final HttpEntity<?> httpEntity = new HttpEntity<>(headers);
    return testRestTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Void.class, id);
  }
}
