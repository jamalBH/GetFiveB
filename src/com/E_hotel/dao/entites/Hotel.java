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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;


@Entity
public class Hotel implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_hotel ;
	String nom_hotel;
	String paye;
	String address_hotel;
	String tel_hotel ;
	String classe_hotel ;
	String ville_hotel ;
	String image;
	@JsonIgnore
	@OneToMany(cascade= CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "hotel" )
	List<Chambre_categorie> chambre_categorie ;
	
	
	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getPaye() {
		return paye;
	}



	public void setPaye(String paye) {
		this.paye = paye;
	}




	
public String getVille_hotel() {
		return ville_hotel;
	}



	public void setVille_hotel(String ville_hotel) {
		this.ville_hotel = ville_hotel;
	}



	
	public List<Chambre_categorie> getChambre_categorie() {
		return chambre_categorie;
	}



	public void setChambre_categorie(List<Chambre_categorie> chambre_categorie) {
		this.chambre_categorie = chambre_categorie;
	}



	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}



	public Integer getId_hotel() {
		return id_hotel;
	}


	public String getNom_hotel() {
		return nom_hotel;
	}

	public void setNom_hotel(String nom_hotel) {
		this.nom_hotel = nom_hotel;
	}

	public String getAddress_hotel() {
		return address_hotel;
	}

	public void setAddress_hotel(String address_hotel) {
		this.address_hotel = address_hotel;
	}

	public String getTel_hotel() {
		return tel_hotel;
	}

	public void setTel_hotel(String tel_hotel) {
		this.tel_hotel = tel_hotel;
	}

	public String getClasse_hotel() {
		return classe_hotel;
	}

	public void setClasse_hotel(String classe_hotel) {
		this.classe_hotel = classe_hotel;
	}




	
	
	
	
}
