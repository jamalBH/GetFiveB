package service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.E_hotel.dao.entites.Article_categorie;
import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Menu;

public class Allmenus implements Serializable {
	
	

	    private List<Menu> menus;

		public List<Menu> getMenus() {
			return menus;
		}

		public void setMenus(List<Menu> menus) {
			this.menus = menus;
		}

	    
	}
	

