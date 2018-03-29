package com.allago.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allago.dto.KeyInfo;
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
		ArrayList<StockTrend> stockTrends2 = new ArrayList<>();
		
		StockTrend stock = new StockTrend();
		
		Calendar s = Calendar.getInstance();
		s.set(2013, 0, 1);
		Calendar end = Calendar.getInstance();
		end.set(2017, 11, 31);
		for(int i=0; s.compareTo(end)<=0; s.add(Calendar.DATE, 1)) {
			if(i==stockTrends.size()) {
				break;
			}
			String date = String.format("%4d-%02d-%02d", s.get(Calendar.YEAR),s.get(Calendar.MONTH)+1,s.get(Calendar.DAY_OF_MONTH));
			
			StockTrend temp = stockTrends.get(i);
			if(s.get(Calendar.DAY_OF_WEEK)==6) {
				stock.setMarketDate(date);
				stock.setCompCode(temp.getCompCode());
				stock.setClosePrice(temp.getClosePrice());
				stock.setCompName(temp.getCompName());
				stockTrends2.add(stock);
				stock = new StockTrend();
			}
			
			if(!date.equals(temp.getMarketDate())){
				continue;
			}
			i++;
		}
		return stockTrends2;
	}
}
