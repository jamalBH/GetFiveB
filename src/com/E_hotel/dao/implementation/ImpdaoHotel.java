package com.E_hotel.dao.implementation;





import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.interfaces.IdaoHotel;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoHotel implements IdaoHotel {

	public Hotel identifier(String username ,String passe) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Hotel.class);
		
		
		cr.add(Restrictions.eq("username", username)) ;
		Hotel hotel = (Hotel) cr.add(Restrictions.eq("passe_hotel", passe)).uniqueResult();
               
		
		session.close() ;
		return hotel; 
	}

	@Override
	public void ajouter(Hotel h) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(h);
		session.getTransaction().commit();
		
	}
	
	@Transactional
	public Hotel getById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Hotel.class);
		
		Hotel hotel = (Hotel) cr.add(Restrictions.eq("id_hotel", id)).uniqueResult();
		
		session.close() ;
		return hotel;
	}

	
	
	public Hotel modifier(Hotel h) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(session.merge(h));
		session.getTransaction().commit();
		
		return null ;	
	}

	@Override
	public void supprimerById(Integer id) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		Hotel h = (Hotel) session.load(Hotel.class, 1);
		
		session.delete(h);
		session.flush();
	}

	public List<Hotel> findAllHotels() {
    	
	     try{
	     List<Hotel> l_hotel ;
	     SessionFactory sf = HibernateUtil.getSessionFactory();
		 Session session = sf.getCurrentSession();
		 session.beginTransaction();
		 Criteria cr = session.createCriteria(Hotel.class);
			
		 l_hotel = (List<Hotel>) cr.list() ;
		session.getTransaction().commit();	
			
			if(l_hotel.size() > 0){
	        return l_hotel;}
			
			
			
	     }
	     
	     catch (Exception e) {
		
		 
	     }
		
	     return null;
}


}