package com.sentifi.microservice.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sentifi.microservice.constant.ColumnNameEnum;
import com.sentifi.microservice.constant.StockConstants;

import lombok.Data;

@Data
public class NasdagDataResponse implements Serializable {

  private static final long serialVersionUID = -3460408768069659274L;

  private Dataset dataset;

  public ClosePriceData mapToResponse() {
    return ClosePriceData.builder()
        .info(StockInfo.builder().ticker(this.dataset.getDatasetCode()).build())
        .prices(dataset.getData().stream().map(data -> {
          String dateString = (String) data.get(ColumnNameEnum.Date.getIndex());
          Object object = data.get(ColumnNameEnum.Close.getIndex());
          String price = object.toString();
          try {
            return Price.builder()
                .date(new SimpleDateFormat(StockConstants.DATE_FORMAT)
                    .parse(dateString))
                .price(Double.valueOf(Optional.ofNullable(price).orElse("0")))
                .build();
          } catch (NumberFormatException | ParseException e) {
            e.printStackTrace();
          }
          return null;
        }).collect(Collectors.toList())).build();
  }

}
