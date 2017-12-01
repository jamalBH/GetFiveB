package com.E_hotel.dao.interfaces;

import java.util.List;

import com.E_hotel.dao.entites.Article_categorie;

public interface IdaoArticleCategorie {

	public void ajouter(Article_categorie catArticle);

	public List<Article_categorie> findAllCategoriesByMenu(Integer idMenu);
	
	public List<Article_categorie> findAllCategories();
	
	public Article_categorie getById(Integer id);

}
