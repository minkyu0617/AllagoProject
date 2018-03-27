package com.allago.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allago.dto.KeyInfo;
import com.allago.service.KeyService;

@Controller
@RequestMapping("key")
public class KeyController {
	
	@Autowired
	@Qualifier("keyService")
	private KeyService service;
	
	@RequestMapping(value="/trend.action", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public ArrayList<KeyInfo> getList(String keyword) {
		
		ArrayList<KeyInfo> keyList = service.getTrendByKeyword(keyword);
		return keyList;
	}
}
