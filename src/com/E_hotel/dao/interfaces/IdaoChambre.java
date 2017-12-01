package com.E_hotel.dao.interfaces;

import com.E_hotel.dao.entites.Chambre;

public interface IdaoChambre {
	public Chambre getByNum(String str) ;
	void ajouter(Chambre c);
	void ajouterByCategorie(Chambre c , String description ,Integer idhotel);
	Chambre getByCategorie(String n_chambre , String categorie , Integer idhotel) ;
    void supprimer(String n) ; 
    void modifier(Chambre c);
    public Chambre getById(Integer id);
	Chambre getByClient(String username);

}
