package com.E_hotel.dao.interfaces;

import java.util.List;

import com.E_hotel.dao.entites.Commande;

public interface IdaoCommande {

	void ajouter(Commande commaned) ;
	public List<Commande> getnvResteau( Integer idhotel);
	public List<Commande> getnvService( Integer idhotel);
	List<Commande> findAllServiceCommands(Integer idhotel);
	List<Commande> findAllResteauCommands(Integer idhotel);
	public void  modifierEtat(Commande c);
	public Commande getById(Integer id);
	public List<Commande> getCommandesByClient(Integer idclient) ;
	public float calculeTotalCommandes(List<Commande> lc);
	
}
