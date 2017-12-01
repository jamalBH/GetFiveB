package com.E_hotel.metier;

import java.util.List;

import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.form.ChambreForm;

public interface IChambreMetier {

	public void addChambre(ChambreForm chambreForm);
	public List<Chambre> findAllChambres(Integer idhotel);
	public void modifierStatutByClient(String username);

}
