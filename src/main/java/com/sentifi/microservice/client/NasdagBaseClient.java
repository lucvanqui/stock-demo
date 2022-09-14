package com.sentifi.microservice.client;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

public class NasdagBaseClient extends BaseClient {

  @Override
  public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
      T resquestBody, Class<T> responseClass) {
    try {
      return super.exchange(url, method, resquestBody, responseClass);
    } catch (HttpClientErrorException e) {
      if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Invalid ticker");
      }
      if (e.getStatusCode() == HttpStatus.TOO_MANY_REQUESTS) {
        throw new ResponseStatusException(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED,
            "Please wait to next day to request again");
      }
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
    }
  }

}
