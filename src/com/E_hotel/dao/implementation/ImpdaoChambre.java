
package com.E_hotel.dao.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Reservation;
import com.E_hotel.dao.interfaces.IdaoChambre;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoChambre implements IdaoChambre {

	@Override
	public void ajouter(Chambre c) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(c);
		session.getTransaction().commit();
		
	}
	
	
	//Recherche de list de des chemabres par Hotel=================================================
    public List<Chambre> findAllChambresByHotel(Integer idhotel) {
    	
    	     try{
    	     List<Chambre> chambres ;
    	     SessionFactory sf = HibernateUtil.getSessionFactory();
    		 Session session = sf.getCurrentSession();
    		 session.beginTransaction();
    		 Criteria cr = session.createCriteria(Chambre.class);
    			cr.add(Restrictions.eq("chambre_categorie.hotel.id", idhotel));
    			chambres = (List<Chambre>) cr.list() ;
    		session.getTransaction().commit();	
    			
    			if(chambres.size() > 0){
    	        return chambres;}
    			
    			
    			return null;
    	     }catch (Exception e) {
			 System.out.println("nbg");
			 
    	     }
			
    	     return null;
    }
    
    
	@Transactional
	public Chambre getById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Chambre.class);
		
		Chambre chambre = (Chambre) cr.add(Restrictions.eq("id_chambre", id)).uniqueResult();
		
		session.close() ;
		return chambre;
	}

	
	@Transactional
	public Chambre getByNum(String str) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Chambre.class);
		
		cr.add(Restrictions.eq("n_chambre", str));
		
		Chambre chambre = (Chambre) cr.list().get(0);
		
		session.close() ;
		return chambre;
	}
	
	@Override
	public void supprimer(String n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifier(Chambre c) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(session.merge(c));
		session.getTransaction().commit();
		
		
	}

	@Override
	public void ajouterByCategorie(Chambre c, String description, Integer idhotel) {
		Chambre_categorie chc = new ImpdaoChambre_categorie().getbyhotel(description,idhotel);
	    c.setChambre_categorie(chc);
	    IdaoChambre addc = (IdaoChambre) new ImpdaoChambre() ;
		addc.ajouter(c);		
	}

	@Override
	public Chambre getByCategorie(String n_chambre, String categorie, Integer idhotel) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		
		Criteria cr = session.createCriteria(Chambre.class,"chambre");
		cr.createAlias("chambre.chambre_categorie", "chambre_categorie");
		cr.createAlias("chambre_categorie.hotel", "hotel");
		cr.add(Restrictions.eq("hotel.id_hotel", idhotel));
		cr.add(Restrictions.eq("chambre_categorie.description",categorie));
		cr.add(Restrictions.eq("chambre.N_chambre",n_chambre));
		Chambre chambre = (Chambre) cr.list().get(0);
		
		return chambre;
	}

	@Override
	public Chambre getByClient(String username) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		
		Criteria cr = session.createCriteria(Reservation.class,"reservation");
		
		cr.createAlias("reservation.client", "client");
		cr.add(Restrictions.eq("client.user",username));
		
		Reservation reservation = (Reservation) cr.list().get(0);
		session.close() ;
		return reservation.getChambre();
	
	}

	

}
