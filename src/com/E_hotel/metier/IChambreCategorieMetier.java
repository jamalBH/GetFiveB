package com.E_hotel.metier;

import java.util.List;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.form.ChambreCategorieForm;

public interface IChambreCategorieMetier {

	public void addChambreCategorie(ChambreCategorieForm chambreCategorieForm);
	public List<Chambre_categorie> findAllCategories(Integer idhotel);
}
