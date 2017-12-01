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
public class ServiceController {

	
	@Autowired
	ImpdaoUser impdaouser ;
	@Autowired
	Hotel hot ;
	@Autowired
	ImpdaoCommande impC;
	@Autowired
	ICommandeMetier commandemetier ;
	
	@RequestMapping(value="/services",method=RequestMethod.GET)
	public String getService(Model model){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		model.addAttribute("f", hot.getId_hotel());
		List<Commande> lc = impC.findAllServiceCommands(hot.getId_hotel());
		model.addAttribute("lc", lc);
		return "services";
	}
	
	@RequestMapping(value="/validerService",method=RequestMethod.GET)
	public String validerService(Model model,HttpServletRequest request){
		 
		commandemetier.validerEtatService(Integer.parseInt(request.getParameter("idcmd")));

				return"redirect:services";
	}
	
	@RequestMapping(value="/annulerService",method=RequestMethod.GET)
	public String anullerService(Model model,HttpServletRequest request){
		 
		commandemetier.anullerEtatService(Integer.parseInt(request.getParameter("idcmd")));

				return"redirect:services";
	}
	
}
