package com.sentifi.microservice.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sentifi.microservice.model.NasdagDataResponse;
import com.sentifi.microservice.model.SearchParameters;

@Component
public class NasdagRestClient extends BaseClient {

  private static final String FILTER_STOCK_BY_TIME_SERIES_SUBFIX = "/WIKI/%s.%s";

  @Value("${external.rest.nasdag.url}")
  private String url;

  public ResponseEntity<NasdagDataResponse> findStockInfo(String ticker,
      SearchParameters params) {
    return exchange(buildFullUri(ticker, params), HttpMethod.GET, null,
        NasdagDataResponse.class);
  }

  @Override
  public String buildUri() {
    return this.url;
  }

  private String buildFullUri(String ticker, SearchParameters params) {
    Optional<String> param = Optional.empty();
    if (params != null) {
      param = Optional.ofNullable(params.toParameterUriFormat());
    }
    return formatUri(buildUri() + FILTER_STOCK_BY_TIME_SERIES_SUBFIX, ticker,
        "json") + param.orElse("");
  }

  private String formatUri(String uri, Object... filledData) {
    return String.format(uri, filledData);
  }

}
