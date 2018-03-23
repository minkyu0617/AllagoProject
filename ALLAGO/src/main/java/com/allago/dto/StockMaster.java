package com.allago.dto;

import java.util.ArrayList;
import lombok.Data;

@Data
public class StockMaster {
	int compCode;
	String compName;
	int sectorCode;
	String sector;
	ArrayList<StockTrend> stockTrends;
}
