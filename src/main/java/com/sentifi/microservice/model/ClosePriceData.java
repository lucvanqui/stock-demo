package com.sentifi.microservice.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClosePriceData {
	
	private StockInfo info;
	
	private List<Price> prices;

}
