package com.allago.mapper;

import java.util.ArrayList;

import com.allago.dto.StockTrend;
import com.allago.dto.StockTrend2;

public interface StockMapper {
	
	public ArrayList<StockTrend2> selectTrendByCompCode(String compCode);
}
