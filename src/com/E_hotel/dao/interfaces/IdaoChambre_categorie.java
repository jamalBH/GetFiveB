package com.E_hotel.dao.interfaces;

import com.E_hotel.dao.entites.Chambre_categorie;

public interface IdaoChambre_categorie {
	
	void ajouter(Chambre_categorie chc  );
	
	void ajouterbyhotel(Chambre_categorie chc ,Integer  id_hotel );

	Chambre_categorie getbyhotel(String description ,Integer idhotel) ;
}
//mkyoung