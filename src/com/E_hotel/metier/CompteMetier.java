package com.E_hotel.metier;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Client;
import com.E_hotel.dao.entites.Reservation;
import com.E_hotel.dao.implementation.ImpdaoChambre;
import com.E_hotel.dao.implementation.ImpdaoClient;
import com.E_hotel.dao.implementation.ImpdaoReservation;
import com.E_hotel.dao.interfaces.IdaoChambre;
import com.E_hotel.dao.interfaces.IdaoClient;
import com.E_hotel.dao.interfaces.IdaoReservation;
import com.E_hotel.form.CompteForm;

public class CompteMetier implements ICompteMetier {

	@Autowired
	Client client;
	@Autowired
	Reservation reservation;
	@Autowired
	IdaoClient impC;
	@Autowired
	IdaoReservation impR;
	@Autowired
	Chambre chambre;
	@Autowired
	IdaoChambre impCh;
	
	@Override
	public void addClient(CompteForm compteForm){
		
		Client client = new Client() ;
		client.setAdress(compteForm.getAdress());
		client.setPaye(compteForm.getPaye());
		client.setNom(compteForm.getNom());
		client.setPrenom(compteForm.getPrenom());
		client.setVille(compteForm.getVille());
		
		
		client.setUser(compteForm.getNom()+"@"+generateRandomChar());
		client.setPasse(compteForm.getPrenom());
		Chambre chambre = new Chambre() ;
		chambre = impCh.getById(compteForm.getIdChambre());
		client.setHotel(chambre.getChambre_categorie().getHotel());
		chambre.setStatus(true);
		impCh.modifier(chambre);
		Reservation reservation = new Reservation() ;
		reservation.setChambre(chambre);
		reservation.setClient(client);
		reservation.setStatus(true);
		
		//impC.ajouter(client); 
		
		impR.ajouter(reservation);
	}
	
	@Override
	public Client getClient(int idChambre){
		chambre=impCh.getById(idChambre);
		
		reservation=impR.getByChambreActive(chambre.getId_chambre());
		client=impC.getById(reservation.getClient().getId());
		return client;
	}

	@Override
	public boolean isExist(String username) {
		
		
		
		if (impC.getByUsername(username) == null )   {  return false ;  }
		
		else {  return  true ;  }
	}

	@Override
	public boolean validation(String username, String pass) {
		
		client = impC.getByUsername(username);
		
		if(client != null && pass != null) {
			
			if( client.getPasse().equals(pass) ) {return true ; }
			
			
			return false; }
		
		return false ;
		
		
	}
	
	
	public Client getClientByUsername(String username){
		
		
		return impC.getByUsername(username) ;
	}
	
	
	//RANDOM FUNCTION
		private static final Random RANDOM = new SecureRandom();
		
		 public static String generateRandomChar()
		  {
		      // Pick from some letters that won't be easily mistaken for each
		      // other. So, for example, omit o O and 0, 1 l and L.
		      String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789@";

		      String pw = "";
		      for (int i=0; i<3; i++)
		      {
		          int index = (int)(RANDOM.nextDouble()*letters.length());
		          pw += letters.substring(index, index+1);
		      }
		      return pw;
		  }
}
