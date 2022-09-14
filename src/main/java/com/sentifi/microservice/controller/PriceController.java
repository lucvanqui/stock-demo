package com.sentifi.microservice.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sentifi.microservice.constant.StockConstants;
import com.sentifi.microservice.model.ClosePriceData;
import com.sentifi.microservice.model.MovingAvarageResponse;
import com.sentifi.microservice.service.PriceService;

@RestController
@RequestMapping("api/v1")
public class PriceController {

  @Autowired
  private PriceService priceService;

  // Story 1
  @GetMapping("/{ticker}/prices")
  public ClosePriceData findClodePriceByStickerAndTime(
      @PathVariable(name = "ticker", required = true) String ticker,
      @RequestParam(name = "start_date", required = false) @DateTimeFormat(pattern = StockConstants.DATE_FORMAT) Date startDate,
      @RequestParam(name = "end_date", required = false) @DateTimeFormat(pattern = StockConstants.DATE_FORMAT) Date endDate) {
    return priceService.findClosePrice(ticker, startDate, endDate);
  }

  // Story 2
  @GetMapping("/{ticker}/200dma")
  public MovingAvarageResponse find200MovingAvarage(
      @PathVariable(name = "ticker", required = true) String ticker,
      @RequestParam(name = "start_date", required = false) @DateTimeFormat(pattern = StockConstants.DATE_FORMAT) Date startDate) {
    return priceService.findMovingAvarage(200, ticker, startDate);
  }

}
