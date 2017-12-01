package com.E_hotel.form;

import javax.validation.constraints.Size;

public class CompteForm {
	
	String ville;
	String paye;
	@Size(min=2,max=25)
	String nom;
	@Size(min=2,max=25)
	String prenom;
	String adress;
	Integer idChambre;
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

	public Integer getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(Integer idChambre) {
		this.idChambre = idChambre;
	}
	public CompteForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
