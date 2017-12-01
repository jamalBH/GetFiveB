package com.E_hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Client;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.dao.interfaces.IdaoChambre;
import com.E_hotel.form.CompteForm;
import com.E_hotel.metier.ChambreCategorieMetier;
import com.E_hotel.metier.ChambreMetier;
import com.E_hotel.metier.CompteMetier;
import com.E_hotel.metier.IChambreMetier;
import com.E_hotel.metier.IClientMetier;
import com.E_hotel.metier.IReservationMetier;

@Controller
public class CompteController {

	@Autowired
	ImpdaoUser impdaouser ;
	@Autowired
    IChambreMetier chambreMetier;
	@Autowired
	ChambreCategorieMetier chambreCat;
	@Autowired
	Hotel hot ;
	@Autowired
	CompteMetier cmptMetier;
	@Autowired
	IClientMetier clientmetier;
	@Autowired
	IReservationMetier reservationmetier;
	
	
	@RequestMapping(value="/compte",method = RequestMethod.GET)
   	public String compte(Model model){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
		model.addAttribute("l", l);
		model.addAttribute("compte", new CompteForm());
		String str = null;
		
		model.addAttribute("k", str);
		
   		return "compte";
   	}
	
	@RequestMapping(value="/addCompte",method = RequestMethod.POST)
   	public String addcompte(Model model,@Valid @ModelAttribute(value="compte") CompteForm compteForm,BindingResult result){
		
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		if(result.hasErrors()){
		
		List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
		model.addAttribute("l", l);
		model.addAttribute("compte", new CompteForm());
   		return "compte";
   		}else{
   			cmptMetier.addClient(compteForm);
   			
			return "redirect:compte";
   		}
		
   	}
	
	@RequestMapping(value="/getInfos")
   	public String getClient(Model model,HttpServletRequest request){
	//	if(request.getParameter("item")!=null || request.getParameter("item")!=""){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("nameHotel", hot.getNom_hotel());
		List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
		model.addAttribute("l", l);
		model.addAttribute("compte", new CompteForm());
		int id = Integer.parseInt(request.getParameter("item"));
		model.addAttribute("Client", cmptMetier.getClient(id));
   		return "compte";
		//return "redirect:compte";
   	}
	
	
	@RequestMapping(value="/fermerCompte")
   	public String fermerCompte(Model model,HttpServletRequest request){
		if(request.getParameter("username")!="" || request.getParameter("idClient")!=""){
			
		
		chambreMetier.modifierStatutByClient(request.getParameter("username"));
		clientmetier.modifierPass(request.getParameter("username"));
		reservationmetier.modifierEtatReservation(Integer.parseInt(request.getParameter("idClient")));
   		return "redirect:compte";
		}
		
		 return "redirect:facture"; 
   	}
	
}
