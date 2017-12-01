package com.E_hotel.dao.implementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.interfaces.IdaoChambre_categorie;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoChambre_categorie implements IdaoChambre_categorie {
	
//AJOUTER CATEGORIE =======================================================================
	public void ajouter(Chambre_categorie chc) {
	
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(chc);
		session.getTransaction().commit();
	
		
	}

	
//Recherche de ChambreCategorie par hotel et nom de categories======================================
	public Chambre_categorie getbyhotel(String nom_categorie_chambre, Integer idhotel) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		
		Criteria cr = session.createCriteria(Chambre_categorie.class);
		cr.add(Restrictions.eq("hotel.id", idhotel));
		cr.add(Restrictions.like("nom_chambre_categorie","%"+nom_categorie_chambre+"%"));
		Chambre_categorie chambre_categorie = (Chambre_categorie) cr.list().get(0);
		session.close() ;
		return chambre_categorie ;
	}



	@Override
	public void ajouterbyhotel(Chambre_categorie chc, Integer id_hotel) {
		
		
	}
	//Recherche de Categories by ID Categories=================================================
	public Chambre_categorie getById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Chambre_categorie.class);
		
		Chambre_categorie chambre_categorie = (Chambre_categorie) cr.add(Restrictions.eq("id_chambre_categorie", id)).uniqueResult();
		
		session.close() ;


		return chambre_categorie;
		}
	//Recherche de list de Categorie par Hotel=================================================
    public List<Chambre_categorie> findAllCategoriesByHotel(Integer idhotel) {
    	
    	     try{
    	     List<Chambre_categorie> categories ;
    	     SessionFactory sf = HibernateUtil.getSessionFactory();
    		 Session session = sf.getCurrentSession();
    		 session.beginTransaction();
    		 Criteria cr = session.createCriteria(Chambre_categorie.class);
    			cr.add(Restrictions.eq("hotel.id", idhotel));
    			categories = (List<Chambre_categorie>) cr.list() ;
    		session.getTransaction().commit();	
    			
    			if(categories.size() > 0){
    	        return categories;}
    			
    			
    			return null;
    	     }catch (Exception e) {
			 System.out.println("nbg");
			 
    	     }
			
    	     return null;
    }

}
