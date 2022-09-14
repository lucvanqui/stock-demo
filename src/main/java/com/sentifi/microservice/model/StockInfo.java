package com.sentifi.microservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockInfo {

  private String ticker;

}
