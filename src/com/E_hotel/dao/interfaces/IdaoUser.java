package com.E_hotel.dao.interfaces;

import com.E_hotel.dao.entites.User;

public interface IdaoUser {

	User findByUserName(String username);
	public void ajouter(User user);
}