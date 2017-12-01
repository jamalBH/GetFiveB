package com.E_hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.E_hotel.dao.entites.Commande;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.implementation.ImpdaoCommande;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.metier.CommandeMetier;
import com.E_hotel.metier.ICommandeMetier;

@Controller
public class RestauController {

	@Autowired
	ImpdaoUser impdaouser ;
	@Autowired
	Hotel hot ;
	@Autowired
	ImpdaoCommande impC;
	@Autowired
	ICommandeMetier commandemetier ;
	
	@RequestMapping(value="/resteau",method=RequestMethod.GET)
	public String getREST(Model model){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		model.addAttribute("f", hot.getId_hotel());
		List<Commande> lc = impC.findAllResteauCommands(hot.getId_hotel());
		model.addAttribute("lc", lc);
		return "resteau";
	}
	
	@RequestMapping(value="/validerResteau",method=RequestMethod.GET)
	public String validerResteau(Model model,HttpServletRequest request){
		 
		
		commandemetier.validerEtatResteau(Integer.parseInt(request.getParameter("idcmd")));
		
				return"redirect:resteau";
	}
	
	
	@RequestMapping(value="/anullerResteau",method=RequestMethod.GET)
	public String anullerResteau(Model model,HttpServletRequest request){
		 
		
		commandemetier.anullerEtatResteau(Integer.parseInt(request.getParameter("idcmd")));
		
				return"redirect:resteau";
	}
	
	
}
