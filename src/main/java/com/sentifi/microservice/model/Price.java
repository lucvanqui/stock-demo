package com.sentifi.microservice.model;

import java.util.Date;

import lombok.Data;

@Data
public class Price {
	
	private Date date;
	
	private double price;

}
