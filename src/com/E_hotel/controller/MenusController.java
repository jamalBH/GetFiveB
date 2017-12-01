package com.E_hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.Menu;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.form.ArticleCategorieForm;
import com.E_hotel.form.ArticleForm;
import com.E_hotel.form.MenuForm;
import com.E_hotel.metier.ArticleCategorieMetier;
import com.E_hotel.metier.ArticleMetier;
import com.E_hotel.metier.MenuMetier;

@Controller
public class MenusController {
	
	@Autowired
	MenuMetier menuMetier;
	@Autowired
	ArticleCategorieMetier categMetier;
	@Autowired
	ImpdaoUser impDaoUser;
	@Autowired
	Hotel hotel;
	@Autowired
	ArticleMetier artMetier;
	
	
	@RequestMapping(value="/menus",method = RequestMethod.GET)
	public String getpage(Model model){
		model.addAttribute("menu", new MenuForm());
		model.addAttribute("categ", new ArticleCategorieForm());
		hotel = (impDaoUser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
		List<Menu> m = menuMetier.findAllMenus(hotel.getId_hotel());
		model.addAttribute("m", m);
		model.addAttribute("idHotel", hotel.getId_hotel());
		model.addAttribute("nameHotel", hotel.getNom_hotel());
		model.addAttribute("article", new ArticleForm());

		return "menus";
	}
	

	@RequestMapping(value="/addMenu",method = RequestMethod.POST)
	public String addM(Model model,@Valid @ModelAttribute(value="menu") MenuForm menuForm,BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("menu", new MenuForm());
			model.addAttribute("categ", new ArticleCategorieForm());
			hotel = (impDaoUser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
			List<Menu> m = menuMetier.findAllMenus(hotel.getId_hotel());
			model.addAttribute("m", m);
			model.addAttribute("idHotel", hotel.getId_hotel());
			model.addAttribute("nameHotel", hotel.getNom_hotel());
			model.addAttribute("article", new ArticleForm());
			return "menus";
		}else{
			menuMetier.addMenu(menuForm);
			return "redirect:menus";
		}
	}
	
	@RequestMapping(value="/addCateg")
	public String addC(Model model,@Valid @ModelAttribute(value="categ") ArticleCategorieForm articleCategorieForm,BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("menu", new MenuForm());
			model.addAttribute("categ", new ArticleCategorieForm());
			hotel = (impDaoUser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
			List<Menu> m = menuMetier.findAllMenus(hotel.getId_hotel());
			model.addAttribute("m", m);
			model.addAttribute("idHotel", hotel.getId_hotel());
			model.addAttribute("nameHotel", hotel.getNom_hotel());
			model.addAttribute("article", new ArticleForm());
			return "menus";
		}else{
			categMetier.addArticleCategorie(articleCategorieForm);
			return "redirect:menus";
		}
	}
	
	@RequestMapping(value="/addArticle")
	public String addArticle(Model model,@Valid @ModelAttribute(value="article") ArticleForm articleForm,BindingResult result){
		if(result.hasErrors()){
			model.addAttribute("menu", new MenuForm());
			model.addAttribute("categ", new ArticleCategorieForm());
			hotel = (impDaoUser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel(); 
			List<Menu> m = menuMetier.findAllMenus(hotel.getId_hotel());
			model.addAttribute("m", m);
			model.addAttribute("idHotel", hotel.getId_hotel());
			model.addAttribute("nameHotel", hotel.getNom_hotel());
			model.addAttribute("article", new ArticleForm());
			return "menus";
		}else{
			artMetier.addArticle(articleForm);
			return "redirect:menus";
		}
	}
	
	
}
