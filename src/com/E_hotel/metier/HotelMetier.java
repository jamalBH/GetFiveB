package com.E_hotel.metier;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.User;
import com.E_hotel.dao.entites.UserRole;
import com.E_hotel.dao.implementation.ImpdaoHotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.dao.implementation.ImpdaoUserRole;
import com.E_hotel.dao.interfaces.IdaoHotel;
import com.E_hotel.form.HotelForm;

public class HotelMetier implements IHotelMetier {
	@Autowired
	ImpdaoHotel impdaoHotel;
	
	
	@Autowired
	ImpdaoUser impUser;
	
	@Autowired
	ImpdaoUserRole userRoleImp;
	

	public ImpdaoHotel getImpdaoHotel() {
		return impdaoHotel;
	}

	public void setImpdaoHotel(ImpdaoHotel impdaoHotel) {
		this.impdaoHotel = impdaoHotel;
		
	}

	
	
	@Override
	public void addHotel(HotelForm hotel){
		
		Hotel h = new Hotel();
		h.setNom_hotel(hotel.getNom());
		h.setAddress_hotel(hotel.getAdresse());
		h.setVille_hotel(hotel.getVille());
		h.setPaye(hotel.getPaye());
		h.setClasse_hotel(hotel.getClasse());
		h.setTel_hotel(hotel.getTel());
		if(hotel.getImage()== ""){
			h.setImage("http://www.hotel-r.net/im/hotel/asia/hk/hotel-icon-0.jpg");
		}else{
			h.setImage(hotel.getImage());
		}
		
		User user = new User() ;
		user.setHotel(h);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(hotel.getPassword());
		user.setUsername(hotel.getUsername());
		user.setPassword(hashedPassword);
		UserRole userRole = new UserRole() ;
		userRole.setUser(user);
		userRole.setRole(hotel.getRole());
		//impdaoHotel.ajouter(h);
		//impUser.ajouter(user);
		userRoleImp.ajouter(userRole);
	}
	
	@Override
	public void updateHotel(HotelForm hotel){
		Hotel h = impdaoHotel.getById(hotel.getIdHotel()) ;
		//h.setId_hotel(hotel.getIdHotel());
		h.setNom_hotel(hotel.getNom());
		h.setAddress_hotel(hotel.getAdresse());
		h.setVille_hotel(hotel.getVille());
		h.setPaye(hotel.getPaye());
		h.setClasse_hotel(hotel.getClasse());
		h.setTel_hotel(hotel.getTel());
		
		impdaoHotel.modifier(h);
	}

	@Override
	public List<Hotel> findAllHotels() {
		
	return	impdaoHotel.findAllHotels();
		
	}
}
