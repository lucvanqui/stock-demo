package com.sentifi.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    ResponseEntity<NasdagDataResponse> stockInfo = nasdagRestClient
        .findStockInfo("FB", null);

    assertNotNull(stockInfo);
    assertNotNull(stockInfo.getBody());
    assertNotNull(stockInfo.getBody().getDataset_data());
    assertEquals("FB", stockInfo.getBody().getDataset_data().getDataset_code());

  }

}
