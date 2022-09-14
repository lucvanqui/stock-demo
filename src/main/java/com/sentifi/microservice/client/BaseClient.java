package com.sentifi.microservice.client;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sentifi.microservice.util.JSONUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseClient {

  @Autowired
  private RestTemplate restTemplate;

  public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
      T resquestBody, Class<T> responseClass) {
    log.info("Request: URL = {} ", url);
    if (Objects.nonNull(resquestBody)) {
      log.info("Body request: \n{}",
          JSONUtil.convertObjectToPrettyJson(resquestBody));
    }
    final ResponseEntity<T> responseEntity = restTemplate.exchange(url,
        HttpMethod.GET, toHttpEntity(resquestBody), responseClass);
    log.info("Body Response: \n{}",
        JSONUtil.convertObjectToPrettyJson(responseEntity.getBody()));
    return responseEntity;
  }

  protected static <T> HttpEntity<T> toHttpEntity(T body) {
    final HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

    if (Objects.isNull(body)) {
      return new HttpEntity<>(httpHeaders);
    }
    return new HttpEntity<>(body, httpHeaders);
  }
}
