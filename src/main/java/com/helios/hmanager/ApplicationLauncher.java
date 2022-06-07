package com.helios.hmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application launcher.
 *
 * @author Iliyan Venkov
 */
@SpringBootApplication
public class ApplicationLauncher {

  public static void main(final String[] args) {
    SpringApplication.run(ApplicationLauncher.class, args);
  }
}
