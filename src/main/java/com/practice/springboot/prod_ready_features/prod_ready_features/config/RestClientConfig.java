package com.practice.springboot.prod_ready_features.prod_ready_features.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Configuration
public class RestClientConfig {

    @Value("${employeeService.base.url}")
    private String baseURL;

      @Bean
      @Qualifier("employee")
      RestClient getEmployeeRestClient(){
          return RestClient.builder()
                  .baseUrl(baseURL)
                  .defaultHeader(CONTENT_TYPE,APPLICATION_JSON_VALUE)
                  .defaultStatusHandler(HttpStatusCode::is5xxServerError, (res, req) ->{
                      throw new RuntimeException("Server is down");
                  })
                  .build();
      }
}
