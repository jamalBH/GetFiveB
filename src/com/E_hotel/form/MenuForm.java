package com.E_hotel.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MenuForm {
	
	
	Integer idHotel;
	@NotNull(message="Choisi un type SVP!")
	String typeMenu;
	@Size(min=4,max=30,message="Donner un nom a votre MENU!")
	String nomMenu;
	
	
	public Integer getIdHotel() {
		return idHotel;
	}




	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}




	public String getTypeMenu() {
		return typeMenu;
	}




	public void setTypeMenu(String typeMenu) {
		this.typeMenu = typeMenu;
	}




	public String getNomMenu() {
		return nomMenu;
	}




	public void setNomMenu(String nomMenu) {
		this.nomMenu = nomMenu;
	}




	
	
	public MenuForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
