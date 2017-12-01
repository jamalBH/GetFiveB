package com.E_hotel.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.Menu;
import com.E_hotel.dao.implementation.ImpdaoHotel;
import com.E_hotel.dao.implementation.ImpdaoMenu;
import com.E_hotel.form.MenuForm;

public class MenuMetier implements IMenuMetier{
	@Autowired
	ImpdaoMenu impdao;
	@Autowired
	Menu m;
	@Autowired
	Hotel hotel;
	@Autowired
	ImpdaoHotel impHotel;
	@Autowired
	ImpdaoMenu impMenu;
	
	public void addMenu(MenuForm menu){
		
		hotel = impHotel.getById(menu.getIdHotel());
		m.setNomMenu(menu.getNomMenu());
		m.setHotel(hotel);
		m.setTypeMenu(menu.getTypeMenu());
		
		impdao.ajouter(m);
	}
	
	
	@Override
	public List<Menu> findAllMenus(Integer idhotel) {
		List<Menu> list = impMenu.findAllMenusByHotel(idhotel);
		return list ;
}
	
	@Override
	public List<Menu> findAllMenusRestau(Integer idhotel) {
		List<Menu> list = impMenu.findAllMenusRestauByHotel(idhotel);
		return list ;
}
	
	@Override
	public List<Menu> findAllMenusService(Integer idhotel) {
		List<Menu> list = impMenu.findAllMenusServiceByHotel(idhotel);
		return list ;
}
}
