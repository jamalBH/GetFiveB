package com.E_hotel.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.User;
import com.E_hotel.dao.entites.UserRole;
import com.E_hotel.dao.implementation.ImpdaoHotel;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.dao.implementation.ImpdaoUserRole;
import com.E_hotel.form.UserForm;

public class UserMetier implements IUserMetier{

	@Autowired
	UserRole userRole;
	@Autowired
	ImpdaoUserRole userRoleImp;
	@Autowired
	User us;
	@Autowired
	ImpdaoUser impUser;
	@Autowired
	Hotel hotel;
	@Autowired
	ImpdaoHotel impHotel;
	@Autowired
	UserRole userrole ;
	
	
	
	@Override
	public void addUser(UserForm user) {
		hotel= (impUser.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())).getHotel();
		us.setUsername(user.getName());
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		us.setPassword(hashedPassword);
		us.setHotel(hotel);
		userRole.setRole(user.getRole());
		userRole.setUser(us);
		userRoleImp.ajouter(userRole);
		//impUser.ajouter(us);
	}

}
