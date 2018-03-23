package com.allago.dto;

import java.util.ArrayList;
import lombok.Data;

@Data
public class StockMaster {
	String compCode;
	String compName;
	String sectorCode;
	String sector;
	ArrayList<StockTrend> stockTrends;
}
