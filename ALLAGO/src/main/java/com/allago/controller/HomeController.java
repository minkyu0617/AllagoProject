package com.allago.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = {"/","home.action"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpServletRequest req) {		
		
		ServletContext context = req.getServletContext();
		
		return "home";
	}
	
}
