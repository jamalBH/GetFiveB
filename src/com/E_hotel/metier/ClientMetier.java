package com.E_hotel.metier;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Client;
import com.E_hotel.dao.interfaces.IdaoClient;

public class ClientMetier implements IClientMetier{

	@Autowired 
	IdaoClient daoclient ;
	
	
	@Override
	public void modifierPass(String username) {

		Client client = daoclient.getByUsername(username) ;
		client.setPasse(null);
		daoclient.modifier(client);
		return ;
	}

}
