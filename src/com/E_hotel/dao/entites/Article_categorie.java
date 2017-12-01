package com.E_hotel.dao.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
public class Article_categorie implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idArticleCategorie;
	private String nomCategorie;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "idService")
	Menu service;
	
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(cascade= CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "article_categorie")
	private List<Article> article;

	
	





	public List<Article> getArticle() {
		return article;
	}






	public void setArticle(List<Article> article) {
		this.article = article;
	}






	public Integer getIdArticleCategorie() {
		return idArticleCategorie;
	}






	public void setIdArticleCategorie(Integer idArticleCategorie) {
		this.idArticleCategorie = idArticleCategorie;
	}






	public Menu getService() {
		return service;
	}






	public void setService(Menu service) {
		this.service = service;
	}






	
	
	
	
	
	
	public Article_categorie() {
		super();
		// TODO Auto-generated constructor stub
	}






	public String getNomCategorie() {
		return nomCategorie;
	}






	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}






	
	

}
