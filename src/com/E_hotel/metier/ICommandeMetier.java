package com.E_hotel.metier;

import java.util.List;

import com.E_hotel.dao.entites.Article;
import com.E_hotel.dao.entites.Commande;

import service.CommandeParser;


public interface ICommandeMetier {
	public void coverteJson(String json ,Integer id_hotel ,String  username) ;
	  public List<Commande> getCommandeByHotel(Integer idhotel) ;
	  public void  validerEtatResteau(Integer id_commande) ;
	  public void  anullerEtatResteau(Integer id_commande);
	  public void  validerEtatService(Integer id_commande);
	  public void  anullerEtatService(Integer id_commande);
	  
}
