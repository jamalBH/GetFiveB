package com.E_hotel.form;


import javax.validation.constraints.Size;

public class UserForm {

	private Integer idHotel;
	@Size(min=2,max=20)
	private String name;
	@Size(min=2,max=20)
	private String password;
	
	private String role;
	
	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}
	
}
