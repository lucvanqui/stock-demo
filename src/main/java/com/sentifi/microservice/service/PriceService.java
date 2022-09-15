package com.sentifi.microservice.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sentifi.microservice.client.NasdagClient;
import com.sentifi.microservice.constant.ColumnNameEnum;
import com.sentifi.microservice.model.ClosePriceData;
import com.sentifi.microservice.model.MovingAvarageResponse;
import com.sentifi.microservice.model.MovingAverageItem;
import com.sentifi.microservice.model.NasdagDataResponse;
import com.sentifi.microservice.model.SearchParameters;

@Service
public class PriceService {

  @Autowired
  private NasdagClient nasdagRestClient;

  public ClosePriceData findClosePrice(String ticker, Date startDate,
      Date endDate) {
    ResponseEntity<NasdagDataResponse> stockInfo = nasdagRestClient
        .findStockInfo(ticker,
            SearchParameters.builder().startDate(startDate).endDate(endDate)
                .columnIndex(ColumnNameEnum.Close.getIndex()).build());

    if (!stockInfo.hasBody()) {
      return null;
    }
    return stockInfo.getBody().mapToResponse();
  }

  public MovingAvarageResponse findMovingAvarage(Integer ma, String ticker,
      Date startDate) {
    ResponseEntity<NasdagDataResponse> stockInfo = nasdagRestClient
        .findStockInfo(ticker,
            SearchParameters.builder()
             .startDate(startDate)
             .columnIndex(ColumnNameEnum.Close.getIndex()).limit(ma)
             .order("asc").build());
    if (!stockInfo.hasBody()) {
      return null;
    }
    List<List<Object>> data = stockInfo.getBody().getDataset().getData();
    int dataSize = data.size();
    if (dataSize != ma) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(
          "No data for %s, possile start date should be %s", startDate, null));
    }
    Double avg = data.stream().map(a -> a.get(ColumnNameEnum.Close.getIndex()))
        .collect(Collectors
            .summingDouble(price -> Double.valueOf(price.toString())));
    return MovingAvarageResponse.builder()
        .dma200(MovingAverageItem.builder().ticker(ticker).average(avg).build())
        .build();
  }

}
