package com.sentifi.microservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sentifi.microservice.client.NasdagRestClient;
import com.sentifi.microservice.model.NasdagDataResponse;

@SpringBootTest(classes = MicroserviceApplication.class)
public class NasdagClientIT {

  @Autowired
  private NasdagRestClient nasdagRestClient;

  @Test
  public void testGetStockNasdag() {
    ResponseEntity<NasdagDataResponse> findStockInfo = nasdagRestClient
        .findStockInfo("FB", null);
    System.out.println(findStockInfo);
  }

}
