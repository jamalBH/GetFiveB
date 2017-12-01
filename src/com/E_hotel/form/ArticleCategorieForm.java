package com.E_hotel.form;

import javax.validation.constraints.Size;

public class ArticleCategorieForm {

	@Size(min=2,max=25)
	private String name;
	private Integer idMenu;
    
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	public ArticleCategorieForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
