package com.E_hotel.dao.entites;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Chambre_categorie implements Serializable {
	 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	Integer id_chambre_categorie;
	String nom_chambre_categorie;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelId")
	Hotel hotel ;
    
	
	@OneToMany(cascade= CascadeType.ALL ,fetch = FetchType.LAZY, mappedBy = "chambre_categorie" )
	List<Chambre> chambres ;
    
	public Integer getId_chambre_categorie() {
		return id_chambre_categorie;
	}
	public void setId_chambre_categorie(Integer id_chambre_categorie) {
		this.id_chambre_categorie = id_chambre_categorie;
	}
	public String getNom_chambre_categorie() {
		return nom_chambre_categorie;
	}
	public void setNom_chambre_categorie(String nom_chambre_categorie) {
		this.nom_chambre_categorie = nom_chambre_categorie;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Chambre_categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Chambre> getChambres() {
		return chambres;
	}
	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
    
	/*   
	                   <c:forEach items="${l.cat}" var="cat">
                        <c:out value="${cat.nom_chambre_categorie} "/>
	                   </c:forEach> */

}
