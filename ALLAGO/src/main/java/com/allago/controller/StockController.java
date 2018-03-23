package com.allago.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.allago.dto.StockTrend;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@RequestMapping(value="/trend.action", method = RequestMethod.GET)
	public ArrayList<StockTrend> getList(int compCode) {
		
		ArrayList<StockTrend> stockTrends = new ArrayList<>();
		
		return stockTrends;
	}
}
