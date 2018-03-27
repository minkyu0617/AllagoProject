package com.allago.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.allago.dao.StockDao;
import com.allago.dto.StockTrend;
import com.allago.dto.StockTrend2;

@Service(value="stockService")
public class StockService {
	
	@Autowired
	@Qualifier("stockDao")
	private StockDao dao;
	
	public ArrayList<StockTrend> getStockList() {
		
		ArrayList<StockTrend> stockList = dao.selectStockList();
		return stockList;
	}
	
	public ArrayList<StockTrend2> getTrendByCompCode(String compCode) {
		ArrayList<StockTrend2> stockTrends = dao.selectTrendByCompCode(compCode);
		return stockTrends;
	}
}
