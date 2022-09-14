package com.sentifi.microservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ColumnNameEnum {
  Date(0), Open(1), High(2), Low(3), Close(4), Volume(5), ExDividend(6),
  SplitRatio(7), AdjOpen(8), AdjHigh(9), AdjLow(10), AdjClose(11),
  AdjVolume(12);

  private int index;

}
