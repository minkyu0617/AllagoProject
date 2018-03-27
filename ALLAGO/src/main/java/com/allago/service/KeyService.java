package com.allago.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.allago.dao.KeyDao;
import com.allago.dto.KeyInfo;

@Service(value="keyService")
public class KeyService {
	
	@Autowired
	@Qualifier("keyDao")
	private KeyDao dao;
	
	public ArrayList<KeyInfo> getTrendByKeyword(String keyword) {
		
		ArrayList<KeyInfo> keyList = dao.selectTrendByKeyword(keyword);
		return keyList;
	}
}
