package com.E_hotel.dao.interfaces;


import com.E_hotel.dao.entites.Reservation;

public interface IdaoReservation {

	public void ajouter(Reservation reservation);
	public void modifier(Reservation r) ;
	public Reservation getByChambreActive(Integer id) ;
	public Reservation getByIdClient(Integer idclient);

}
