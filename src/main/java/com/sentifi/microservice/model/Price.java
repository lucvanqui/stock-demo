package com.sentifi.microservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

  @JsonFormat(pattern = "yyyy-MM-dd'T'00:00:00.000'Z'")
  private Date date;

  private double price;

}
