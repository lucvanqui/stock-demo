package com.sentifi.microservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MovingAvarageResponse {

  @JsonProperty("200dma")
  private MovingAverageItem dma200;

}
