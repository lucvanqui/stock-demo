package com.sentifi.microservice.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Dataset implements Serializable {

  private static final long serialVersionUID = 6933512868865068341L;

  private int id;

  private String dataset_code;

  private String database_code;

  private String name;

  private String description;

  private String refreshed_at;

  private Date newest_available_date;

  private Date oldest_available_date;

  private List<String> column_names;

  private String frequency;

  private String type;

  private boolean premium;

  private String limit;

  private String transform;

  private int column_index;

  private Date start_date;

  private Date end_date;

  private List<List<Object>> data;

  private String collapse;

  private String order;

  private int database_id;

}
