package com.E_hotel.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




public class ChambreForm {

	@NotNull
	@Size(min=1,max=10,message = "Inserer un N° correct a votre chambre SVP!")
	String N_chambre ;
	
	Integer chambre_categorie ;

	public Integer getChambre_categorie() {
		return chambre_categorie;
	}

	public void setChambre_categorie(Integer chambre_categorie) {
		this.chambre_categorie = chambre_categorie;
	}

	public String getN_chambre() {
		return N_chambre;
	}

	public void setN_chambre(String n_chambre) {
		N_chambre = n_chambre;
	}
	
	
}
