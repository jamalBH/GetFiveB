package com.E_hotel.controller;

import java.util.List;

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
import com.E_hotel.metier.ChambreMetier;
import com.E_hotel.metier.CommandeMetier;
import com.E_hotel.metier.CompteMetier;
import com.E_hotel.metier.ICommandeMetier;

@Controller
public class CommandeController {

	@Autowired
	ImpdaoUser impdaouser ;
	@Autowired
	ChambreMetier chambreMetier;
	@Autowired
	ICommandeMetier commandemetier;
	@Autowired
	Hotel hot ;
	@Autowired
	CompteMetier cmptMetier;
	@Autowired
	IdaoCommande daocommande  ;
	
	
	@RequestMapping(value="/affichercommande",method = RequestMethod.GET)
   	public String affichercommande(Model model){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel();
		
	//	List<Commande> l = daocommande.getbyhotel(hot.getId_hotel());
		
   		return null;
   	}
	
}
