package com.E_hotel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.RetString;



@Controller
public class ControllerAndroTests {

	
	@Autowired
	RetString retstring  ;
	
	
	@RequestMapping(value = "/hot",produces="application/json")
	public @ResponseBody RetString getHotels(HttpServletRequest request) {
		
		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDD");
		retstring.setText("KHDMAAAT");
		return retstring;
}
	
	@RequestMapping(value = "/toto",produces="application/json")
	public @ResponseBody void tttt(HttpServletRequest request) {
		
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTT");
}
	
}
