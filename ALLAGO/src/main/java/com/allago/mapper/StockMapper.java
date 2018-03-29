package com.allago.mapper;

import java.util.ArrayList;

import com.allago.dto.StockMaster;
import com.allago.dto.StockTrend;

public interface StockMapper {
	
//	public ArrayList<StockTrend> selectStockList();
	public ArrayList<StockTrend> selectTrendByCompCode(String compCode);
	public ArrayList<StockTrend> selectTrendList();
	//public StockMaster selectMasterByCompCode(String compCode);
	public StockMaster selectMasterByCompName(String compName);
}
