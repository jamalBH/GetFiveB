package com.E_hotel.metier;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Reservation;
import com.E_hotel.dao.interfaces.IdaoReservation;

public class ReservationMetier implements IReservationMetier {
	
	@Autowired 
	IdaoReservation daoreservation ;
	
	public void modifierEtatReservation(Integer idclient){
		
		
		Reservation reservation = daoreservation.getByIdClient(idclient) ;
		reservation.setStatus(false);
		daoreservation.modifier(reservation);
		return ;
		
	}
}
