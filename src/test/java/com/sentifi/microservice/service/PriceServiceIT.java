package com.sentifi.microservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sentifi.microservice.MicroserviceApplication;
import com.sentifi.microservice.model.ClosePriceData;

@SpringBootTest(classes = MicroserviceApplication.class)
public class PriceServiceIT {

  @Autowired
  private PriceService priceService;

  @Test
  public void testFindClosePriceForFB() throws ParseException {
    ClosePriceData closePrice = priceService.findClosePrice("FB",
        new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-01"),
        new SimpleDateFormat("yyyy-MM-dd").parse("2015-01-31"));
    assertNotNull(closePrice);
    assertNotNull(closePrice.getInfo());
    assertNotNull(closePrice.getInfo().getTicker());
    assertNotNull(closePrice.getPrices());
    assertNotNull(closePrice.getPrices().get(0));
    assertEquals("FB", closePrice.getInfo().getTicker());
    assertNotNull(closePrice.getPrices().get(0).getDate());
    assertNotNull(closePrice.getPrices().get(0).getPrice());

  }

}
