package com.allago.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.allago.mapper.StockMapper;

@Repository(value="stockDao")
public class StockDao {
	
	@Autowired
	@Qualifier("stockMapper")
	StockMapper stockMapper;
	
}
