package com.E_hotel.dao.interfaces;

import java.util.List;

import com.E_hotel.dao.entites.Menu;

public interface IdaoMenu {

	public void ajouter(Menu menu);
	public Menu getById(Integer id);
	public List<Menu> findAllMenusRestauByHotel(Integer idhotel);
	public List<Menu> findAllMenusServiceByHotel(Integer idhotel);
	public List<Menu> findAllMenusByHotel(Integer idhotel);

}
