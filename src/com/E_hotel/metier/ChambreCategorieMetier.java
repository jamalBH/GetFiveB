package com.E_hotel.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.User;
import com.E_hotel.dao.implementation.ImpdaoChambre_categorie;
import com.E_hotel.dao.implementation.ImpdaoHotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.form.ChambreCategorieForm;

public class ChambreCategorieMetier implements IChambreCategorieMetier{

	@Autowired
	ImpdaoChambre_categorie impCa;
	@Autowired
	ImpdaoHotel impHo;
	@Autowired
	Chambre_categorie categorie;
	@Autowired
	Hotel hotel;
	@Autowired
	ImpdaoUser impdaouser ;
	@Override
	public void addChambreCategorie(ChambreCategorieForm chambreCategorieForm) {
		categorie.setNom_chambre_categorie(chambreCategorieForm.getNom_chambre_categorie());
		hotel=(impdaouser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel() ;
		categorie.setHotel(hotel);
		impCa.ajouter(categorie);
		
	}
	
	@Autowired
	ImpdaoChambre_categorie impCHC;


	@Override
	public List<Chambre_categorie> findAllCategories(Integer idhotel) {
		//CategoriesByHotelForm categories = impCHC.findAllCategoriesByHotel(idhotel);
		List<Chambre_categorie> list = impCHC.findAllCategoriesByHotel(idhotel);
		return list ;
}
}
