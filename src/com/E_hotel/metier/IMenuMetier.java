package com.E_hotel.metier;

import java.util.List;

import com.E_hotel.dao.entites.Menu;
import com.E_hotel.form.MenuForm;

public interface IMenuMetier {
	public void addMenu(MenuForm menu);

	public List<Menu> findAllMenus(Integer idhotel);
	public List<Menu> findAllMenusRestau(Integer idhotel);

	public List<Menu> findAllMenusService(Integer idhotel);

}
