package com.sentifi.microservice.util;

import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sentifi.microservice.constant.StockConstants;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@UtilityClass
@Slf4j
public final class JSONUtil {

  private static final ObjectMapper OBJECT_MAPPER;

  static {
    OBJECT_MAPPER = new ObjectMapper();
    OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
        false);
  }

  public static String convertObjectToJson(Object object) {
    if (Objects.isNull(object)) {
      return StockConstants.EMPTY_STRING;
    }
    try {
      return OBJECT_MAPPER.writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      log.error("Convert list objects to json array has exception: ", ex);
      return StockConstants.EMPTY_STRING;
    }
  }

  public static String convertObjectToPrettyJson(Object object) {
    if (Objects.isNull(object)) {
      return StockConstants.EMPTY_STRING;
    }
    try {
      return OBJECT_MAPPER.writerWithDefaultPrettyPrinter()
          .writeValueAsString(object);
    } catch (JsonProcessingException ex) {
      log.error("Convert list objects to json array has exception: ", ex);
      return StockConstants.EMPTY_STRING;
    }
  }

}
