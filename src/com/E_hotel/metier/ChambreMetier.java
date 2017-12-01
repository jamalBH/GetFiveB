package com.E_hotel.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.implementation.ImpdaoChambre;
import com.E_hotel.dao.implementation.ImpdaoChambre_categorie;
import com.E_hotel.form.ChambreForm;

public class ChambreMetier implements IChambreMetier {
	@Autowired
	ImpdaoChambre impdaoChambre;
	@Autowired
	ImpdaoChambre_categorie imp;
	@Autowired
	Chambre chambre;
	@Autowired
	Chambre_categorie chc;
	
	@Override
	public void addChambre(ChambreForm chambreForm) {
		//Chambre chambre = new Chambre();
		//Chambre_categorie chc= new Chambre_categorie();
		chambre.setN_chambre(chambreForm.getN_chambre());
		chambre.setStatus(false);
		chc=imp.getById(chambreForm.getChambre_categorie());
		chambre.setChambre_categorie(chc);
		impdaoChambre.ajouter(chambre);
	}
	
	@Override
	public List<Chambre> findAllChambres(Integer idhotel){
		return impdaoChambre.findAllChambresByHotel(idhotel);
	}
	
	public void modifierStatutByClient(String username){
		
		Chambre chambre = impdaoChambre.getByClient(username) ;
		chambre.setStatus(false);
		impdaoChambre.modifier(chambre);
		return ;
		
	}

	
}
