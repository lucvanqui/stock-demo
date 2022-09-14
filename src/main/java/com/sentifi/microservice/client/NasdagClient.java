package com.sentifi.microservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sentifi.microservice.model.NasdagDataResponse;
import com.sentifi.microservice.model.SearchParameters;
import com.sentifi.microservice.service.NasdagEndpointGenerator;

@Component
public class NasdagClient extends NasdagBaseClient {

  @Autowired
  private NasdagEndpointGenerator endpointGenerator;

  public ResponseEntity<NasdagDataResponse> findStockInfo(String ticker,
      SearchParameters params) {
    return exchange(endpointGenerator.buildFullUri(ticker, params),
        HttpMethod.GET, null, NasdagDataResponse.class);
  }

}
