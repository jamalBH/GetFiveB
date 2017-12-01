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
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Chambre implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Integer id_chambre ;
	String n_chambre;
	Boolean status;
	@ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chambre_categorie")
	Chambre_categorie chambre_categorie ;
   	
	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Chambre_categorie getChambre_categorie() {
		return chambre_categorie;
	}

	public void setChambre_categorie(Chambre_categorie chambre_categorie) {
		this.chambre_categorie = chambre_categorie;
	}

	public Integer getId_chambre() {
		return id_chambre;
	}

	public void setId_chambre(Integer id_chambre) {
		this.id_chambre = id_chambre;
	}







	public String getN_chambre() {
		return n_chambre;
	}

	public void setN_chambre(String n_chambre) {
		this.n_chambre = n_chambre;
	}

	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
