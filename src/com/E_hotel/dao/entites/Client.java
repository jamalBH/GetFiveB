package com.E_hotel.dao.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String ville;
	String paye;
	String nom;
	String prenom;
	String adress;
	String user;
	String passe;
	@ManyToOne
	Hotel hotel ;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}










	public String getVille() {
		return ville;
	}



	public void setVille(String ville) {
		this.ville = ville;
	}



	public String getPaye() {
		return paye;
	}



	public void setPaye(String paye) {
		this.paye = paye;
	}



	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPasse() {
		return passe;
	}

	public void setPasse(String passe) {
		this.passe = passe;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	
}
