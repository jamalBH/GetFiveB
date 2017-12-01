package com.E_hotel.dao.entites;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
@Entity
public class Menu implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Integer idService;
	String nomMenu;
	String typeMenu;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(cascade= CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "service")
	private List<Article_categorie> article_categorie;

	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	Hotel hotel ;
	
	public String getTypeMenu() {
		return typeMenu;
	}


	public void setTypeMenu(String typeMenu) {
		this.typeMenu = typeMenu;
	}

	public Integer getIdService() {
		return idService;
	}



	public void setIdService(Integer idService) {
		this.idService = idService;
	}



	public String getNomMenu() {
		return nomMenu;
	}



	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}




	
	
	
	public List<Article_categorie> getArticle_categorie() {
		return article_categorie;
	}


	public void setArticle_categorie(List<Article_categorie> article_categorie) {
		this.article_categorie = article_categorie;
	}


	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
