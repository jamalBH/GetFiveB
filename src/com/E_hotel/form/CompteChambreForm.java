package com.E_hotel.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class CompteChambreForm {

	@NotNull
	@Size(min=2,max=15)
	String nom;
	@NotNull
	@Size(min=2,max=15)
	String prenom;
	@NotNull
	@Size(min=2,max=150)
	String adresse;
	
	String paye;
	
	Integer chambre;
	@DateTimeFormat
	Date dateReservation;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPaye() {
		return paye;
	}
	public void setPaye(String paye) {
		this.paye = paye;
	}
	public Integer getChambre() {
		return chambre;
	}
	public void setChambre(Integer chambre) {
		this.chambre = chambre;
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	
	
}
