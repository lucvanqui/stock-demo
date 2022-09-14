package com.sentifi.microservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sentifi.microservice.constant.StockConstants;

import io.micrometer.core.instrument.util.StringUtils;

public final class DateUtil {

  public static final Date parseStringToDate(final String dateString)
      throws ParseException {
    if (StringUtils.isBlank(dateString)) {
      return null;
    }
    return new SimpleDateFormat(StockConstants.DATE_FORMAT).parse(dateString);
  }

  public static final String dateToString(final Date date) {
    if (date == null) {
      return "";
    }
    return new SimpleDateFormat(StockConstants.DATE_FORMAT).format(date);
  }

}
