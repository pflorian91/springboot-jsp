package com.webgenerals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.webgenerals")
public class WgWebJspApp extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(WgWebJspApp.class);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(WgWebJspApp.class);
  }
}