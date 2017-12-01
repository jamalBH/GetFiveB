package com.E_hotel.controller;


import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.Menu;
import com.E_hotel.metier.CompteMetier;
import com.E_hotel.metier.HotelMetier;
import com.E_hotel.metier.ICommandeMetier;
import com.E_hotel.metier.ICompteMetier;
import com.E_hotel.metier.IMenuMetier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import service.RetString;
import service.TokenManager;




@Controller

public class AndroidController {
	@Autowired
	TokenManager tokenmanager ;
	@Autowired
	ICompteMetier comptemetier  ;
	@Autowired
	RetString retstring  ;
	@Autowired
	HotelMetier hotelmetier ;
	@Autowired
	IMenuMetier menumetier ;
	@Autowired
	ICommandeMetier commande ;
	
	@RequestMapping(value="/android" ,produces="application/json")
	@ResponseBody  RetString validation(HttpServletRequest request){
		
		String username = request.getParameter("username") ;
		String pass = request.getParameter("pass") ;
		
		
		if (comptemetier.validation(username,pass)){
			
			Integer id_hotel = comptemetier.getClientByUsername(username).getHotel().getId_hotel() ;
			
			retstring.setText(tokenmanager.createToken(username,pass, id_hotel));
			 return  retstring;
			
			} ;
		
			retstring.setText("access denied");
			return  retstring ;
		
		

}
	@RequestMapping(value = "/tt",produces="application/json")
	public @ResponseBody RetString tt(HttpServletRequest request) {
		
		String c = request.getParameter("commandeParser") ;
		int idhotel = tokenmanager.getIdHotel(request);
		String username = tokenmanager.getUsername(request) ;


		
		commande.coverteJson(c,idhotel,username) ;
		//System.out.println(commande.coverteJson(c,idhotel,username).getLigne_commande().get(0).getQte()+"ttttttttttttttttttttttttttttt");

		retstring.setText("access denied");
		return  retstring ;
		}
	
	
	
	@RequestMapping(value = "/hotels",produces="application/json")
	public @ResponseBody Map getHotels(HttpServletRequest request) {
		Map results = new HashMap();
		results.put("hotels",  hotelmetier.findAllHotels());
		 return  results;
		}
	
	@RequestMapping(value = "/listmenus",produces="application/json")
	public @ResponseBody Map Menus(HttpServletRequest request) {
		Map results = new HashMap();
		int idhotel = tokenmanager.getIdHotel(request);
		//int idhotel = Integer.parseInt(request.getParameter("idhotel"));
		results.put("menus",  menumetier.findAllMenusRestau(idhotel));
		 return  results;
		}
	@RequestMapping(value = "/listservice",produces="application/json")
	public @ResponseBody Map Services(HttpServletRequest request) {
		Map results = new HashMap();
		//String token=request.getParameter("token");
		int idhotel = tokenmanager.getIdHotel(request);
		//int idhotel = Integer.parseInt(request.getParameter("idhotel"));
		results.put("menus",  menumetier.findAllMenusService(idhotel));
		 return  results;
		}
	
	@RequestMapping(value = "/allmenus",produces="application/json")
	public @ResponseBody String getmenus(HttpServletRequest request) {
		 String t ;
		 ObjectMapper mapper = new ObjectMapper();
		 
		//Integer id_hotel =	tokenmanager.getIdHotel(request)  ; 
		 
        List<Menu> menu = menumetier.findAllMenus(1) ;
       
	        try {
	        
	          t = (String) mapper.writerWithDefaultPrettyPrinter().writeValueAsString(menu.get(0));
	           
	        } catch (JsonProcessingException e) {
	        	
	        	return  null ;
	        }       
		
		 return  t ;
		
}





}