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

@Entity
public class Commande implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Integer id_commande ; 
	
	String etatResteau  ;
	String etatService ;
	String date ;
	
	
	
	@OneToMany(cascade= CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "commande" )
	List<Ligne_Commande> ligne_commande  ;
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chambre")
	Chambre chambre ;	
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
	Client client ;	
	
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
	Hotel hotel ;

	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getId_commande() {
		return id_commande;
	}

	public void setId_commande(Integer id_commande) {
		this.id_commande = id_commande;
	}



	public String getEtatResteau() {
		return etatResteau;
	}

	public void setEtatResteau(String etatResteau) {
		this.etatResteau = etatResteau;
	}

	public String getEtatService() {
		return etatService;
	}

	public void setEtatService(String etatService) {
		this.etatService = etatService;
	}

	public List<Ligne_Commande> getLigne_commande() {
		return ligne_commande;
	}

	public void setLigne_commande(List<Ligne_Commande> ligne_commande) {
		this.ligne_commande = ligne_commande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	
	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
