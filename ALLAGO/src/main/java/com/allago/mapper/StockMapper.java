package com.allago.mapper;

import java.util.ArrayList;

import com.allago.dto.StockTrend;

public interface StockMapper {
	
	public ArrayList<StockTrend> selectTrendByCompCode(int compCode);
	
}
