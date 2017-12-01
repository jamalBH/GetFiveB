package com.E_hotel.dao.entites;


import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Article implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_article;
	String nom_article;
	float prix_article;
	String description;
	String image;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "idArticleCategorie")
	Article_categorie article_categorie ;
	
	public Article() {
		super();
	}

	public Integer getId_article() {
		return id_article;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	public void setId_article(Integer id_article) {
		this.id_article = id_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public float getPrix_article() {
		return prix_article;
	}

	public void setPrix_article(float prix_article) {
		this.prix_article = prix_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Article_categorie getArticle_categorie() {
		return article_categorie;
	}

	public void setArticle_categorie(Article_categorie article_categorie) {
		this.article_categorie = article_categorie;
	}


	
	
	
}
