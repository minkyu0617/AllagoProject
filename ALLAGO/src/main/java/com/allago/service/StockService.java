package com.allago.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.allago.dao.StockDao;
import com.allago.dto.StockTrend;

@Service(value="stockService")
public class StockService {
	
	@Autowired
	@Qualifier("stockDao")
	private StockDao dao;
	
	public ArrayList<StockTrend> getStockTrend(int compCode) {
		
		ArrayList<StockTrend> stockTrends = new ArrayList<>();
		return stockTrends;
	}
}
