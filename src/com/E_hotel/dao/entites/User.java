package com.E_hotel.dao.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
@Entity
@Table(name="users")
public class User{
    @Id
	private String username;
	private String password;
	private boolean enabled = true;
    @ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")	
	private Hotel hotel ;
	@OneToMany(cascade= CascadeType.ALL , fetch = FetchType.LAZY , mappedBy = "user")
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	
	
	
	
	
	public User(String username, String password, boolean enabled, Hotel hotel, Set<UserRole> userRole) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.hotel = hotel;
		this.userRole = userRole;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}



	public User() {
	}

	
	
	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

}
