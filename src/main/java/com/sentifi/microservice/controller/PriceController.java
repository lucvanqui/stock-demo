package com.sentifi.microservice.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sentifi.microservice.model.ClosePriceData;

@RestController
@RequestMapping("api/v1")
public class PriceController {

	@GetMapping("/{ticker}/prices")
	public ClosePriceData findClodePriceByStickerAndTime(@
			PathVariable(name = "ticker", required = true) String ticker,
			@RequestParam(name = "start_date", required = false) Date startDate,
			@RequestParam(name = "end_date", required = false) Date endDate) {
		return ClosePriceData.builder().build();

	}

}
