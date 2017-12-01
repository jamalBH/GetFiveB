package com.E_hotel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Commande;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.dao.interfaces.IdaoCommande;
import com.E_hotel.form.CompteForm;
import com.E_hotel.metier.ChambreCategorieMetier;
import com.E_hotel.metier.CompteMetier;

@Controller
public class FactureController {

	@Autowired
	ImpdaoUser impdaouser ;
	@Autowired
	Hotel hot;
	@Autowired
	ChambreCategorieMetier chambreCat;
	@Autowired
	CompteMetier cmptMetier;
	@Autowired
	IdaoCommande daocommande;

	@RequestMapping(value="/facture",method = RequestMethod.GET)
	   	public String facture(Model model){
		 hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
			model.addAttribute("nameHotel", hot.getNom_hotel());
			List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
			model.addAttribute("l", l);
	   		return "facture";
	   	}
	 
	 
	 @RequestMapping(value="/findUserInfos")
	   	public String getClient(Model model,HttpServletRequest request){
		 if(request.getParameter("item") !=null){
			hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
			model.addAttribute("nameHotel", hot.getNom_hotel());
			List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
			model.addAttribute("l", l);
			int id = Integer.parseInt(request.getParameter("item"));
			model.addAttribute("Client", cmptMetier.getClient(id));
			List<Commande> lc = daocommande.getCommandesByClient(cmptMetier.getClient(id).getId()) ;
			 if(lc !=null){    model.addAttribute("total", daocommande.calculeTotalCommandes(lc)) ;
             model.addAttribute("listCom", lc);}else{
            	 model.addAttribute("total", 0) ;
             }
	   		return "facture";}
		 return "redirect:facture";
	   	}
	 
	 @RequestMapping(value="/detailfacture")
	   	public String detailfacture(Model model,HttpServletRequest request){
		 if(request.getParameter("idClient") !=""){
			 hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
				model.addAttribute("nameHotel", hot.getNom_hotel());
				List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
				model.addAttribute("l", l);
			List<Commande> lc = daocommande.getCommandesByClient(Integer.parseInt(request.getParameter("idClient"))) ;
			model.addAttribute("total", daocommande.calculeTotalCommandes(lc)) ;
			model.addAttribute("listCom", lc);
			
	   		return "facture";}
		 return "redirect:facture";
	   	}
	 

	 
}
