package com.E_hotel.metier;

import java.util.List;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.form.HotelForm;


public interface IHotelMetier {

	public void addHotel(HotelForm hotel);

	public void updateHotel(HotelForm hotel);
	
	public List<Hotel> findAllHotels() ;
}
