package com.E_hotel.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.implementation.ImpdaoHotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.form.ChambreCategorieForm;
import com.E_hotel.form.ChambreForm;
import com.E_hotel.form.HotelForm;
import com.E_hotel.form.UserForm;
import com.E_hotel.metier.ChambreCategorieMetier;
import com.E_hotel.metier.ChambreMetier;
import com.E_hotel.metier.IHotelMetier;
import com.E_hotel.metier.UserMetier;



@Controller
public class ProfileController   {

	@Autowired
	UserMetier userMetier;
	@Autowired
	IHotelMetier hotelMetier;
	@Autowired
	ChambreMetier chambreMetier;
	@Autowired
	ChambreCategorieMetier chambreCat;
	@Autowired
	ImpdaoHotel impdaohotel;
	@Autowired
	ImpdaoUser impdaouser ;
	Hotel hot ;
	
	
	
	
	@RequestMapping(value="/profile",method = RequestMethod.GET)
	public String showHotelPage(Model model){
		
		Set<String> roles = AuthorityUtils
                .authorityListToSet(SecurityContextHolder.getContext()
                        .getAuthentication().getAuthorities());
        if (!roles.contains("ROLE_ADMIN")) {
            return "redirect:facture" ;
        }
       
		
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		model.addAttribute("hot", hot);
		model.addAttribute("user", new UserForm());
		model.addAttribute("hotelUpdate", new HotelForm());
		model.addAttribute("chambre",	new ChambreForm());
		model.addAttribute("categorie", new ChambreCategorieForm());
		model.addAttribute("nameHotel", hot.getNom_hotel());
		List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
		model.addAttribute("l", l);
		return "profile";
	}
	
	@RequestMapping(value="/saveChambre",method = RequestMethod.POST)
 	public String addHot(Model model,@Valid @ModelAttribute(value="chambre") ChambreForm chambreForm,BindingResult result){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		if(result.hasErrors()){
			model.addAttribute("nameHotel", hot.getNom_hotel());
			model.addAttribute("hotelUpdate", new HotelForm());
			model.addAttribute("user", new UserForm());
			model.addAttribute("hot", hot);			
			model.addAttribute("categorie", new ChambreCategorieForm());
			List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
			model.addAttribute("l", l);
			return "profile";
		}else{
			chambreMetier.addChambre(chambreForm);
		//	model.addAttribute("chambre",	new ChambreForm());
		
			return "redirect:profile";
		}
 	}
	
	@RequestMapping(value="/saveCat",method = RequestMethod.POST)
 	public String addHot(Model model,@Valid @ModelAttribute(value="categorie") ChambreCategorieForm chambreCatForm,BindingResult result){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		if(result.hasErrors()){
			
			model.addAttribute("hot", hot);
			model.addAttribute("hotelUpdate", new HotelForm());
			model.addAttribute("user", new UserForm());
			model.addAttribute("chambre",	new ChambreForm());
			List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
			model.addAttribute("l", l);
			model.addAttribute("idHotel", hot.getId_hotel());
			model.addAttribute("nameHotel", hot.getNom_hotel());
			return "profile";
		}else{
			chambreCat.addChambreCategorie(chambreCatForm);
			//model.addAttribute("chambre",	new ChambreForm());
			//model.addAttribute("categorie", new ChambreCategorieForm());
			return "redirect:profile";
		}
 	}
	
	//UPDATE HOTEL CONTROLLER========================================================================
	@RequestMapping(value="/updateHotel",method = RequestMethod.POST)
 	public String updateHot(Model model,@Valid @ModelAttribute(value="hotelUpdate") HotelForm hotelForm,BindingResult result){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel();
		hotelForm.setIdHotel(hot.getId_hotel());
		if(result.hasErrors()){
			model.addAttribute("user", new UserForm());
			model.addAttribute("categorie", new ChambreCategorieForm());
			model.addAttribute("chambre",	new ChambreForm());
			List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
			model.addAttribute("l", l);
			model.addAttribute("idHotel", hot.getId_hotel());
			model.addAttribute("nameHotel", hot.getNom_hotel());
			return "profile";
		}else{
			
			hotelMetier.updateHotel(hotelForm);
			return "redirect:profile";
		}
 	}
	
	//CREATE NEW ACCOUNTS FOR USER=========================================================================
	@RequestMapping(value="CreateUser",method = RequestMethod.POST)
	public String addUsers(Model model,@Valid @ModelAttribute(value="user") UserForm userForm,BindingResult result){
		hot = (impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		if(result.hasErrors()){
			
			model.addAttribute("hot", hot);
			model.addAttribute("hotelUpdate", new HotelForm());
			model.addAttribute("chambre",	new ChambreForm());
			model.addAttribute("categorie", new ChambreCategorieForm());
			List<Chambre_categorie> l = chambreCat.findAllCategories(hot.getId_hotel());
			model.addAttribute("l", l);
			model.addAttribute("idHotel", hot.getId_hotel());
			model.addAttribute("nameHotel", hot.getNom_hotel());
			return "profile";
		}else{
			userMetier.addUser(userForm);
			return "redirect:profile";
		}
	}
}
