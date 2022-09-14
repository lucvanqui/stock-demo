package com.sentifi.microservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sentifi.microservice.model.SearchParameters;

@Service
public class NasdagEndpointGenerator implements EndpointGenerator {

  private static final String FILTER_STOCK_BY_TIME_SERIES_SUBFIX = "/WIKI/%s.%s";

  @Value("${external.rest.nasdag.url}")
  private String url;

  @Override
  public String buildUri() {
    return this.url;
  }

  public String buildFullUri(String ticker, SearchParameters params) {
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
