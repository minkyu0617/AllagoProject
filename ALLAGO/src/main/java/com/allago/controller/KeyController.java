package com.allago.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allago.dto.KeyInfo;
import com.allago.dto.StockMaster;
import com.allago.dto.StockTrend;
import com.allago.service.KeyService;
import com.allago.service.StockService;

@Controller
@RequestMapping("key")
public class KeyController {
	
	@Autowired
	@Qualifier("keyService")
	private KeyService keyService;
	
	@Autowired
	@Qualifier("stockService")
	private StockService stockService;
	
	@RequestMapping(value="/count.action", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public ArrayList<KeyInfo> getList(String keyword) {
		ArrayList<KeyInfo> keyList = keyService.getTrendByKeyword(keyword);
		ArrayList<KeyInfo> keyList2 = new ArrayList<>();
		KeyInfo info = new KeyInfo();
		
//		for(int i=0; i<keyList.size(); i++) {
//			KeyInfo temp = keyList.get(i);
//			info.setKeyCount(info.getKeyCount()+temp.getKeyCount());
//			if((i + 3) % 7 == 6) {
//				info.setKeyDate(temp.getKeyDate());
//				info.setKeyName(temp.getKeyName());
//				keyList2.add(info);
//				info = new KeyInfo();
//			}
//			
//		}
		Calendar s = Calendar.getInstance();
		s.set(2013, 0, 1);
		Calendar end = Calendar.getInstance();
		end.set(2017, 11, 31);
		for(int i=0; s.compareTo(end)<=0; s.add(Calendar.DATE, 1)) {
			if(i==keyList.size()) {
				break;
			}
			String date = String.format("%4d%02d%02d", s.get(Calendar.YEAR),s.get(Calendar.MONTH)+1,s.get(Calendar.DAY_OF_MONTH));
			
			KeyInfo temp = keyList.get(i);
			if(s.get(Calendar.DAY_OF_WEEK)==6) {
				info.setKeyDate(date);
				info.setKeyName(temp.getKeyName());
				keyList2.add(info);
				info = new KeyInfo();
			}
			
			if(!date.equals(temp.getKeyDate())){
				continue;
			}
			i++;
			
			info.setKeyCount(info.getKeyCount()+temp.getKeyCount());
		}
		
		//ArrayList<StockMaster> stockMasterList = Compare(keyList);
		return keyList2;
	}
	
	public ArrayList<StockMaster> Compare(ArrayList<KeyInfo> keyList){
		for(KeyInfo k : keyList) {
			//Calendar d = k.getKeyDate();
		}
		
		
		ArrayList<StockTrend> stockTrendList = stockService.getTrendList();
		String compCode="";
		for(StockTrend s : stockTrendList) {
			Date d = s.getMarketDate();
		}
		
		ArrayList<StockMaster> stockMasterList = new ArrayList<>(); 
		stockMasterList.add(stockService.getStockMasterByCompCode(compCode));
		return stockMasterList;
	}
}
