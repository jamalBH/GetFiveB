package com.E_hotel.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ChambreCategorieForm {
	
	@NotNull
	@Size(min=2,max=25,message="Inserer un nom a votre Categorie SVP!")
	String nom_chambre_categorie;

	
	
	
	public String getNom_chambre_categorie() {
		return nom_chambre_categorie;
	}

	public void setNom_chambre_categorie(String nom_chambre_categorie) {
		this.nom_chambre_categorie = nom_chambre_categorie;
	}
	
	
}
