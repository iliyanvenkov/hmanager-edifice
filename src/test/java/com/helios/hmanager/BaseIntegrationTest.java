package com.helios.hmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Base integration test class which setups PostgreSQL docker container.
 *
 * @author Iliyan Venkov
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BaseIntegrationTest {

  @LocalServerPort protected Integer localServerPort;

  @Autowired protected TestRestTemplate testRestTemplate;

  static final PostgreSQLContainer<?> POSTGRESQL_CONTAINER;

  static {
    POSTGRESQL_CONTAINER =
        new PostgreSQLContainer<>("postgres:9.6.12")
            .withUsername("postgres")
            .withPassword("secret")
            .withDatabaseName("test")
            .withReuse(true)
            .withInitScript("db/init.sql");
    POSTGRESQL_CONTAINER.start();
  }

  @DynamicPropertySource
  static void properties(final DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", POSTGRESQL_CONTAINER::getJdbcUrl);
    registry.add("spring.datasource.password", POSTGRESQL_CONTAINER::getPassword);
    registry.add("spring.datasource.username", POSTGRESQL_CONTAINER::getUsername);
  }
}
