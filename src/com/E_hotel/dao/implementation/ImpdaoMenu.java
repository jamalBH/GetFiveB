package com.E_hotel.dao.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


import com.E_hotel.dao.entites.Menu;
import com.E_hotel.dao.interfaces.IdaoMenu;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoMenu implements IdaoMenu{

	
	@Override
	public void ajouter(Menu menu) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(menu);
		session.getTransaction().commit();
		
	}
	
	@Transactional
	public Menu getById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Menu.class);
		
		Menu menu = (Menu) cr.add(Restrictions.eq("idService", id)).uniqueResult();
		
		session.close() ;
		return menu;
	}
	
	//Recherche de list de MENU par Hotel=================================================
    public List<Menu> findAllMenusByHotel(Integer idhotel) {
    	
    	     try{
    	     List<Menu> menu ;
    	     SessionFactory sf = HibernateUtil.getSessionFactory();
    		 Session session = sf.getCurrentSession();
    		 session.beginTransaction();
    		 Criteria cr = session.createCriteria(Menu.class);
    			cr.add(Restrictions.eq("hotel.id", idhotel));
    			menu = (List<Menu>) cr.list() ;
    		session.getTransaction().commit();	
    			
    			if(menu.size() > 0){
    	        return menu;}
    			
    			
    			return null;
    	     }catch (Exception e) {
			 System.out.println("");
			 
    	     }
			
    	     return null;
    }
    
    //Find all menus restau
    public List<Menu> findAllMenusRestauByHotel(Integer idhotel) {
    	
	     try{
	     List<Menu> menu ;
	     SessionFactory sf = HibernateUtil.getSessionFactory();
		 Session session = sf.getCurrentSession();
		 session.beginTransaction();
		 Criteria cr = session.createCriteria(Menu.class);
			cr.add(Restrictions.eq("hotel.id", idhotel));
			cr.add(Restrictions.eq("typeMenu", "Resteau"));
			menu = (List<Menu>) cr.list() ;
		session.getTransaction().commit();	
			
			if(menu.size() > 0){
	        return menu;}
			
			
			return null;
	     }catch (Exception e) {
		 System.out.println("");
		 
	     }
		
	     return null;
}
    //Find all menus service
    public List<Menu> findAllMenusServiceByHotel(Integer idhotel) {
    	
	     try{
	     List<Menu> menu ;
	     SessionFactory sf = HibernateUtil.getSessionFactory();
		 Session session = sf.getCurrentSession();
		 session.beginTransaction();
		 Criteria cr = session.createCriteria(Menu.class);
			cr.add(Restrictions.eq("hotel.id", idhotel));
			cr.add(Restrictions.eq("typeMenu", "Service"));
			menu = (List<Menu>) cr.list() ;
		session.getTransaction().commit();	
			
			if(menu.size() > 0){
	        return menu;}
			
			
			return null;
	     }catch (Exception e) {
		 System.out.println("");
		 
	     }
		
	     return null;
}
    
}
