package com.E_hotel.metier;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Article;
import com.E_hotel.dao.entites.Article_categorie;
import com.E_hotel.dao.implementation.ImpdaoArticle;
import com.E_hotel.dao.implementation.ImpdaoArticleCategorie;
import com.E_hotel.form.ArticleForm;

public class ArticleMetier implements IArticleMetier{

	@Autowired
	Article_categorie artCat;
	@Autowired
	ImpdaoArticleCategorie impCat;
	@Autowired
	Article art;
	@Autowired
	ImpdaoArticle imp;
	
	
	@Override
	public void addArticle(ArticleForm article) {
	
		artCat = impCat.getById(article.getId_categ());
		art.setArticle_categorie(artCat);
		art.setNom_article(article.getNom_article());
		art.setDescription(article.getDescription());
		art.setPrix_article(article.getPrix_article());
		art.setImage(article.getImage());
		
		imp.ajouter(art);
		
	
	}


	@Override
	public Article getArticleById(Integer id) {
		return imp.getArticleById(id);
	}

}
