package com.E_hotel.dao.interfaces;

import com.E_hotel.dao.entites.Article;

public interface IdaoArticle {

	public void ajouter(Article article);
	public Article getArticleById(Integer id) ;
}
