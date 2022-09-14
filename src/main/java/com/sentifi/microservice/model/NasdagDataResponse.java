package com.sentifi.microservice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class NasdagDataResponse implements Serializable {

  private static final long serialVersionUID = -3460408768069659274L;

  private Dataset dataset_data;

  public ClosePriceData map() {
    dataset_data.getData().stream().map(data -> date)
    ClosePriceData.builder()
    .info(StockInfo.builder().ticker(this.dataset_data.getDataset_code()).build())
    .prices(null)
    .build();
    return null;
    
  }

}
