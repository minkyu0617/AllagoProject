package com.allago.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.allago.dto.StockTrend;
import com.allago.mapper.StockMapper;

@Repository(value="stockDao")
public class StockDao {
	
	@Autowired
	@Qualifier("stockMapper")
	StockMapper stockMapper;
	
	public ArrayList<StockTrend> selectStockList() {
		
		ArrayList<StockTrend> stockList = stockMapper.selectStockList();
		return stockList;
	}
	
	public ArrayList<StockTrend> selectTrendByCompCode(String compCode) {
		
		ArrayList<StockTrend> stockTrends = stockMapper.selectTrendByCompCode(compCode);
		return stockTrends;
	}
}
