package com.allago.mapper;

import java.util.ArrayList;

import com.allago.dto.KeyInfo;

public interface KeyMapper {
	
	public ArrayList<KeyInfo> selectTrendByKeyword(String keyword);
}
