package com.allago.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allago.dto.StockTrend;
import com.allago.service.StockService;

@Controller
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	@Qualifier("stockService")
	private StockService service;
	
//	@RequestMapping(value="/default.action", method = RequestMethod.GET, produces="application/json;charset=utf-8")
//	public String getList(Model model) {
//		ArrayList<StockTrend> stockList = service.getStockList();
//		ArrayList<StockTrend> stockTop5 = new ArrayList<>();
//		for(int i = 0; i < 5; i++) {
//			stockTop5.add(stockList.get(i));
//		}
//		
//		model.addAttribute("stocks", stockTop5);
//		return "home";
//	}
	
	@RequestMapping(value="/trend.action", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public ArrayList<StockTrend> getTrend(String compCode) {
		ArrayList<StockTrend> stockTrends = service.getTrendByCompCode(compCode);
		return stockTrends;
	}
}
