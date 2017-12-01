package com.E_hotel.dao.interfaces;

import java.util.List;

import com.E_hotel.dao.entites.Hotel;

public interface IdaoHotel {

	void ajouter(Hotel h);
	
	Hotel  modifier(Hotel h ) ;
	
	Hotel identifier(String username ,String passe) ;
	
	Hotel getById(Integer id) ;
	
	public List<Hotel> findAllHotels() ;
	
	void supprimerById(Integer id) ;
}
