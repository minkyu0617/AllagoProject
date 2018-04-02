package com.allago.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.allago.dto.StockMaster;
import com.allago.dto.StockTrend;
import com.allago.dto.StockTrend2;
import com.allago.mapper.StockMapper;

@Repository(value="stockDao")
public class StockDao {
	
	@Autowired
	@Qualifier("stockMapper")
	StockMapper stockMapper;
	
//	public ArrayList<StockTrend> selectStockList() {
//		
//		ArrayList<StockTrend> stockList = stockMapper.selectStockList();
//		return stockList;
//	}
	
	public ArrayList<StockTrend> selectTrendByCompCode(String compCode) {
		ArrayList<StockTrend> stockTrends = stockMapper.selectTrendByCompCode(compCode);
		return stockTrends;
	}

	public ArrayList<StockTrend> selectTrendList() {
		ArrayList<StockTrend> stockTrends = stockMapper.selectTrendList();
		return stockTrends;
	}

	/*public StockMaster selectMasterByCompCode(String compCode) {
		StockMaster stockMaster = stockMapper.selectMasterByCompCode(compCode);
		return stockMaster;
	}*/

	public ArrayList<StockMaster> selectMasterList(String keyword) {
		ArrayList<StockMaster> stockMasters = new ArrayList<>();
		//ArrayList<String> stockName = new ArrayList<>();
		String [] stockName = null;//new String [5];
		
		if(keyword.equals("알파") || keyword.equals("인공") || keyword.equals("이세돌")) {
			//for(int i=0; i< stockName.length; i++) {
			//	String [] names = {"삼성전자", "SK하이닉스", "신성이엔지", "일진디스플", "DB하이텍"};
			//	stockName[i]= names[i];
			//}
			stockName = new String[]{"삼성전자", "SK하이닉스", "신성이엔지", "일진디스플", "DB하이텍"};
		} else if(keyword.equals("금리")) {
			//for(int i=0; i< stockName.length; i++) {
			//	String [] names = {"KB금융", "신한지주", "기업은행", "우리은행", "한국금융지주"};
			//	stockName[i]= names[i];
			//}
			
			stockName = new String[]{"KB금융", "신한지주", "기업은행", "우리은행", "한국금융지주"};
		} else if(keyword.equals("원유")) {
			//for(int i=0; i< stockName.length; i++) {
			//	String [] names = {"SK이노베이션", "S-Oil", "GS", "금호석유", "효성"};
			//	stockName[i]= names[i];
			//}
			stockName = new String[]{"SK이노베이션", "S-Oil", "GS", "금호석유화학", "효성"};
		}
		
		for(int i=0; i < stockName.length; i++) {
			stockMasters.add(stockMapper.selectMasterByCompName(stockName[i]));	
		}
		return stockMasters;
	}
}
