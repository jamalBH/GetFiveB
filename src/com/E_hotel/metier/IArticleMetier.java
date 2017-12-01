package com.E_hotel.metier;

import com.E_hotel.dao.entites.Article;
import com.E_hotel.form.ArticleForm;

public interface IArticleMetier {

	public void addArticle(ArticleForm article);
	public Article getArticleById(Integer id) ;
}
