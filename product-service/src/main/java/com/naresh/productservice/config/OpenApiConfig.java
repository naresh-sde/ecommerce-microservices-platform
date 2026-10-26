package com.naresh.productservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI productOpenAPI() {
    return new OpenAPI()
      .info(new Info()
        .title("Product Service API")
        .description("Product catalog APIs for e-commerce platform")
        .version("1.0.0"));
  }
}
