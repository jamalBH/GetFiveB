package com.E_hotel.metier;

import com.E_hotel.dao.entites.Client;
import com.E_hotel.form.CompteForm;



public interface ICompteMetier {

	public void addClient(CompteForm compteForm);

	public boolean isExist(String username ) ;

	
	
	public Client getClientByUsername(String username);
	
	
	public boolean validation(String username , String pass) ;

	public Client getClient(int idChambre);

}
