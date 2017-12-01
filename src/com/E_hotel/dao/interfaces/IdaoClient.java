package com.E_hotel.dao.interfaces;

import com.E_hotel.dao.entites.Client;

public interface IdaoClient {

	public Client getByUsername(String username ) ;

	public void ajouter(Client client);

	public Client getById(Integer id);
	public void modifier(Client client) ;
	
}
