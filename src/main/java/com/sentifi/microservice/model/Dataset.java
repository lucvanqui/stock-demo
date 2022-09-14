package com.sentifi.microservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Dataset implements Serializable {

  private static final long serialVersionUID = 6933512868865068341L;

  private int id;

  @JsonProperty("dataset_code")
  private String datasetCode;

  @JsonProperty("database_code")
  private String databaseCode;

  private String name;

  private String description;

  @JsonProperty("refreshed_at")
  private String refreshedAt;

  @JsonProperty("newest_available_date")
  private Date newestAvailableDate;

  @JsonProperty("oldest_available_date")
  private Date oldestAvailableDate;

  @JsonProperty("column_names")
  private List<String> columnNames;

  private String frequency;

  private String type;

  private boolean premium;

  private String limit;

  private String transform;

  @JsonProperty("column_index")
  private int columnIndex;

  @JsonProperty("start_date")
  private Date startDate;

  @JsonProperty("end_date")
  private Date endDate;

  private List<List<Object>> data;

  private String collapse;

  private String order;

  @JsonProperty("database_id")
  private int databaseId;

}
