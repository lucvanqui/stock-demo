package com.sentifi.microservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseClient {

  @Autowired
  private RestTemplate restTemplate;

  public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
      T resquestBody, Class<T> responseClass) {
    log.debug("Sending %s method to %s { %s }", method.name(), url,
        resquestBody.toString());
    return restTemplate.exchange("", HttpMethod.GET,
        new HttpEntity<T>(resquestBody), responseClass);
  }

  public abstract String buildUri();

}
