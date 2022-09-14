package com.sentifi.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.sentifi.microservice.client.NasdagRestClient;
import com.sentifi.microservice.constant.ColumnNameEnum;
import com.sentifi.microservice.model.NasdagDataResponse;
import com.sentifi.microservice.model.SearchParameters;
import com.sentifi.microservice.util.DateUtil;

@SpringBootTest(classes = MicroserviceApplication.class)
public class NasdagClientIT {

  @Autowired
  private NasdagRestClient nasdagRestClient;

  @Test
  public void testGetStockNasdagWithoutTimeFilter() {
    ResponseEntity<NasdagDataResponse> stockInfo = nasdagRestClient
        .findStockInfo("FB", null);

    assertNotNull(stockInfo);
    assertNotNull(stockInfo.getBody());
    assertNotNull(stockInfo.getBody().getDataset_data());
    assertEquals("FB", stockInfo.getBody().getDataset_data().getDataset_code());

  }

  @Test
  public void testGetStockNasdagWithTimeFilter() throws ParseException {

    ResponseEntity<NasdagDataResponse> stockInfo = nasdagRestClient
        .findStockInfo("FB",
            SearchParameters.builder()
                .startDate(DateUtil.parseStringToDate("2018-01-01"))
                .endDate(DateUtil.parseStringToDate("2018-01-31"))
                .columnIndex(ColumnNameEnum.Close.getIndex()).build());

    assertNotNull(stockInfo);
    assertNotNull(stockInfo.getBody());
    assertNotNull(stockInfo.getBody().getDataset_data());
    assertEquals("FB", stockInfo.getBody().getDataset_data().getDataset_code());

  }

}
