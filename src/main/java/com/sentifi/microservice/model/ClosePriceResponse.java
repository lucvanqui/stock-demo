package com.sentifi.microservice.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ClosePriceResponse implements Serializable {

	private static final long serialVersionUID = -6110686166781362771L;
	
	private ClosePriceData data;

}
