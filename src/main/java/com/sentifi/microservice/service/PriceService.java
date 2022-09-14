package com.sentifi.microservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sentifi.microservice.client.NasdagRestClient;
import com.sentifi.microservice.constant.ColumnNameEnum;
import com.sentifi.microservice.model.ClosePriceData;
import com.sentifi.microservice.model.NasdagDataResponse;
import com.sentifi.microservice.model.SearchParameters;

@Service
public class PriceService {

  @Autowired
  private NasdagRestClient nasdagRestClient;

  public ClosePriceData findClosePrice(String ticker, Date startDate,
      Date endDate) {
    ResponseEntity<NasdagDataResponse> stockInfo = nasdagRestClient
        .findStockInfo(ticker,
            SearchParameters.builder().startDate(startDate).endDate(endDate)
                .columnIndex(ColumnNameEnum.Close.getIndex()).build());

    return null;
  }

}
