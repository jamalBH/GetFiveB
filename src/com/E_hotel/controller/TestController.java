package com.E_hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.form.CompteForm;
import com.E_hotel.metier.ChambreCategorieMetier;
import com.E_hotel.metier.ChambreMetier;
import com.E_hotel.metier.CompteMetier;

@Controller
public class TestController {

	@Autowired
	ImpdaoUser impdaouser ;
	@Autowired
	ChambreMetier chambreMetier;
	@Autowired
	ChambreCategorieMetier chambreCat;
	@Autowired
	Hotel hot ;
	@Autowired
	CompteMetier cmptMetier;
	
	
	@RequestMapping(value="/lol",method = RequestMethod.GET)
   	public String compte(Model model){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
		model.addAttribute("l", l);
		model.addAttribute("compte", new CompteForm());
		String str = null;
		model.addAttribute("k", str);
		
   		return "test";
   	}
	
	
	@RequestMapping(value="/test")
   	public String getClient(Model model,HttpServletRequest request){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
		model.addAttribute("l", l);
		model.addAttribute("compte", new CompteForm());
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHXXXXXXX"+request.getParameter("item"));
		request.getParameter("item");
		//model.addAttribute("Client", cmptMetier.getClient(idChambre));
		
   		return "test";
   	}
}
