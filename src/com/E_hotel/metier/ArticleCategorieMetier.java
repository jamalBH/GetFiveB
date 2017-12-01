package com.E_hotel.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Article_categorie;
import com.E_hotel.dao.entites.Menu;
import com.E_hotel.dao.implementation.ImpdaoArticleCategorie;
import com.E_hotel.dao.implementation.ImpdaoMenu;
import com.E_hotel.form.ArticleCategorieForm;

public class ArticleCategorieMetier implements IArticleCategorieMetier{

	@Autowired
	ImpdaoArticleCategorie impCat;
	@Autowired
	Article_categorie cat;
	@Autowired
	Menu menu;
	@Autowired
	ImpdaoMenu impMenu;
	
	@Override
	public void addArticleCategorie(ArticleCategorieForm articleCategorieForm) {
		menu = impMenu.getById(articleCategorieForm.getIdMenu());
		cat.setService(menu);
		cat.setNomCategorie(articleCategorieForm.getName());
		impCat.ajouter(cat);
		
	}
	
	  public List<Article_categorie> findAllCategoriesByMenu(Integer idMenu) {
	    	return impCat.findAllCategoriesByMenu(idMenu);
	    }

	  public List<Article_categorie> findAllCategories() {
	    	return impCat.findAllCategories();
	    }
	
}
