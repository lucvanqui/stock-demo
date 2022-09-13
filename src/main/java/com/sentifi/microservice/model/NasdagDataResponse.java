package com.sentifi.microservice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class NasdagDataResponse implements Serializable {

  private static final long serialVersionUID = -3460408768069659274L;

  private Dataset dataset_data;

}
