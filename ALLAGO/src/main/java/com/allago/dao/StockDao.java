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
	
	public ArrayList<StockTrend> selectTrendByCompCode(int compCode) {
		
		ArrayList<StockTrend> stockTrends = new ArrayList<>();
		return stockTrends;
	}
}
