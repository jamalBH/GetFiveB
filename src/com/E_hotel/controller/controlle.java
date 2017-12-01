package com.E_hotel.controller;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.E_hotel.form.HotelForm;
import com.E_hotel.metier.IHotelMetier;



@Controller
public class controlle {
	
	@Autowired
	IHotelMetier hotelMetier;
	
   /* @RequestMapping("/")
	public String home(){
		return "index";
	}*/
    
	//START PAGE============================================================================================
/*	@RequestMapping(value="/",method = RequestMethod.GET)
	public String showHotelPage(Model model){
		model.addAttribute("hotel",	new HotelForm());
		return "LoginPage";
	}
	*/
	//SAVE NEW HOTEL=========================================================================================
	@RequestMapping(value="/saveHotel2",method = RequestMethod.POST)
 	public String addHot(Model model,@Valid @ModelAttribute(value="hotel") HotelForm hotelForm,BindingResult result){
		if(result.hasErrors()){
			return "LoginPage";
		}else{
			hotelMetier.addHotel(hotelForm);
			return "CompteCreated";
		}
 	}
	//END SAVE NEW HOTEL=========================================================================================

	

	
	
	
	
/*	@RequestMapping(value="/saveHotel1",method = RequestMethod.POST)
 	public String saveHotel(Model model,@RequestParam(value="hotelName") String hotelName
 			,@RequestParam(value="hotelAdresse") String hotelAdresse
 			,@RequestParam(value="hotelVille") String hotelVille
 			,@RequestParam(value="hotelClass") String hotelClasses
 			,@RequestParam(value="hotelTel") String hotelTel
 			,@RequestParam(value="hotelUser") String hotelUser
 			,@RequestParam(value="hotelPass") String hotelPass){
    	

		HotelForm hotelForm = new HotelForm();
		hotelForm.setNom(hotelName);
		hotelForm.setAdresse(hotelAdresse);
		hotelForm.setClasse(hotelClasses);
		hotelForm.setPassword(hotelPass);
		hotelForm.setTel(hotelTel);
		hotelForm.setUsername(hotelUser);
		hotelForm.setVille(hotelVille);
		
 		
	    hotelMetier.addHotel(hotelForm); 

 		return "LoginPage";
 	}*/
     /*
    @RequestMapping("/compte")
   	public String compte(){
   		return "compte";
   	}
    
    
    @RequestMapping("/facture")
   	public String facture(){
   		return "facture";
   	}*/
    
  /*  @RequestMapping("/menus")
   	public String menu(){
   		return "menus";
   	}*/
    
   /* @RequestMapping("/profile")
   	public String profile(){
   		return "profile";
   	}*/
    
    /*
    @RequestMapping("/resteau")
   	public String resteau(){
   		return "resteau";
   	}
    
    @RequestMapping("/services")
   	public String service(){
   		return "services";
   	}*/
}
