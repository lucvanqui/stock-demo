package com.sentifi.microservice.model;

import java.util.Date;

import com.sentifi.microservice.util.DateUtil;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchParameters {

  private Date startDate;

  private Date endDate;

  private Integer columnIndex;

  private Integer limit;

  private String order;

  public String toParameterUriFormat() {
    StringBuilder result = new StringBuilder("?");
    if (startDate != null) {
      result.append("start_date=").append(DateUtil.dateToString(startDate))
          .append("&");
    }
    if (endDate != null) {
      result.append("end_date=").append(DateUtil.dateToString(endDate))
          .append("&");
    }
    if (columnIndex != null) {
      result.append("column_index=").append(columnIndex);
    }
    if (limit != null) {
      result.append("limit=").append(limit);
    }
    if (order != null) {
      result.append("order=").append(order);
    }

    return result.toString();
  }

}
