package com.sentifi.microservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class MovingAverageItem {

  @JsonProperty("Ticker")
  private String ticker;

  @JsonProperty("Avg")
  private Double average;

}
