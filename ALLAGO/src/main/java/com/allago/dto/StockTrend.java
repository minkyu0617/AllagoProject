package com.allago.dto;

import lombok.Data;

@Data
public class StockTrend {
	String compCode;
	String compName;
	String marketDate;
	int volume;
	int closePrice;
}
