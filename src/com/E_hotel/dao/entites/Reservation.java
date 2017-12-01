package com.E_hotel.dao.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Reservation implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_reservation ;
	
	Boolean status;
	
	@ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	Client client ;
	@ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	Chambre chambre ;
	
	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Boolean getStatus() {
		return status;
	}







	public void setStatus(Boolean status) {
		this.status = status;
	}







	public Integer getId_reservation() {
		return id_reservation;
	}



	public void setId_reservation(Integer id_reservation) {
		this.id_reservation = id_reservation;
	}






	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public Chambre getChambre() {
		return chambre;
	}



	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
    
	
	
	
}
