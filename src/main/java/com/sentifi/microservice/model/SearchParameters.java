package com.sentifi.microservice.model;

import java.util.Date;

import lombok.Data;

@Data
public class SearchParameters {

  private Date startDate;

  private Date endDate;

  public String toParameterUriFormat() {
    StringBuilder result = new StringBuilder("?");
    if (startDate != null) {
      result.append(startDate).append("&");
    }
    if (endDate != null) {
      result.append(endDate).append("&");
    }
    return result.toString();
  }

}
