package com.allago.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.allago.dto.KeyInfo;
import com.allago.mapper.KeyMapper;

@Repository(value="keyDao")
public class KeyDao {
	
	@Autowired
	@Qualifier("keyMapper")
	KeyMapper keyMapper;
	
	public ArrayList<KeyInfo> selectTrendByKeyword(String keyword) {
		
		ArrayList<KeyInfo> keyList = keyMapper.selectTrendByKeyword(keyword);
		return keyList;
	}
}
