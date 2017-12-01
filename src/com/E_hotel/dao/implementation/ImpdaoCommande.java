package com.E_hotel.dao.implementation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Commande;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.Ligne_Commande;
import com.E_hotel.dao.interfaces.IdaoCommande;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoCommande implements IdaoCommande {

	@Override
	public void ajouter(Commande commande) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(commande);
		session.getTransaction().commit();
	}
	
	
public List<Commande> getnvResteau( Integer idhotel) {
	
	
	try{
	List<Commande> lc ; 
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		
	Criteria cr = session.createCriteria(Commande.class,"commande");
		
			cr.createAlias("commande.hotel", "hotel");

		cr.add(Restrictions.eq("hotel.id", idhotel));
		cr.add(Restrictions.eq("etatResteau", "x"));
		
		lc = (List<Commande>) cr.list() ;  
	     session.getTransaction().commit();	
	
	       if(lc.size() > 0){   return lc;   } 
           return null;
             
 }
	catch (Exception e) {  e.printStackTrace(); }

      return null;
}



public List<Commande> getnvService( Integer idhotel) {
	
	
	try{
	List<Commande> lc ; 
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		
	Criteria cr = session.createCriteria(Commande.class,"commande");
		
			cr.createAlias("commande.hotel", "hotel");

		cr.add(Restrictions.eq("hotel.id", idhotel));
		cr.add(Restrictions.eq("etatService", "x"));
		
		lc = (List<Commande>) cr.list() ;  
	     session.getTransaction().commit();	
	
	       if(lc.size() > 0){   return lc;   } 
           return null;
             
 }
	catch (Exception e) {  e.printStackTrace(); }

      return null;
}


public float calculeTotalCommandes(List<Commande> lc){
	float s=0 ;
	for(int i=0 ;i<lc.size() ;i++){
	for(int j=0 ; j<lc.get(i).getLigne_commande().size() ; j++){
	
		s+= lc.get(i).getLigne_commande().get(j).getPrix()*lc.get(i).getLigne_commande().get(j).getQte() ;
		
	}
	
	}
	return s;
}

@Override
public List<Commande> findAllResteauCommands(Integer idhotel) {
	List<Commande> lc = getnvResteau(idhotel) ;
if(lc != null)	{
	for(Iterator<Commande> it = lc.iterator(); it.hasNext();)
	{
		Commande ss = it.next() ;
		for(Iterator<Ligne_Commande> iterator = ss.getLigne_commande().iterator(); iterator.hasNext();)
		{

			Ligne_Commande s = iterator.next();
            if(  ! s.getType().equals("resteau")       )
            	
            {   iterator.remove()  ;  
            			

            }
		}
		
		
		if(ss.getLigne_commande().isEmpty()) {it.remove() ;}
		
	}
	

	return lc;      }
return null ;

		
}


@Override
public List<Commande> findAllServiceCommands(Integer idhotel) {
	
	
	
List<Commande> lc = getnvService(idhotel) ;
if(lc != null)	{	
	for(Iterator<Commande> it = lc.iterator(); it.hasNext();)
	{
		Commande ss = it.next() ;
		for(Iterator<Ligne_Commande> iterator = ss.getLigne_commande().iterator(); iterator.hasNext();)
		{

			Ligne_Commande s = iterator.next();
            if(   s.getType().equals("resteau")       )
            	
            {   iterator.remove()  ;  
            			

            }
		}
		
		
		if(ss.getLigne_commande().isEmpty()) {it.remove() ;}
		
	}
	

	return lc;        }
	
	
	return null ;
	
	
	
	
}


public void  modifierEtat(Commande c) {
	
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.getCurrentSession();
	session.beginTransaction();
	
	session.saveOrUpdate(session.merge(c));
	session.getTransaction().commit();
	
	return  ;	
}


public Commande getById(Integer id) {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session = sf.getCurrentSession();
	session.beginTransaction();
	Criteria cr = session.createCriteria(Commande.class);
	
	Commande commande = (Commande) cr.add(Restrictions.eq("id_commande", id)).uniqueResult();
	
	session.close() ;
	return commande;
}


public List<Commande> getCommandesByClient(Integer idclient){
	
	try{
		List<Commande> lc ; 
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.getCurrentSession();
			session.beginTransaction();		
			
		Criteria cr = session.createCriteria(Commande.class,"commande");
			
				cr.createAlias("commande.client", "client");

			cr.add(Restrictions.eq("client.id", idclient));
			
			lc = (List<Commande>) cr.list() ;  
		     session.getTransaction().commit();	
		
		       if(lc.size() > 0){  
		    	   
		    	   
		    	   
		    	   
		    	   
		    	   for(Iterator<Commande> it = lc.iterator(); it.hasNext();)
		    		{
		    			Commande ss = it.next() ;
		    			
		    		if(ss.getEtatResteau().equals("nv") && ss.getEtatService().equals("nv")){   it.remove();   }
		    		if(ss.getEtatResteau().equals("x") && ss.getEtatService().equals("x")){   it.remove();   }
		    		if(ss.getEtatResteau().equals("x") && ss.getEtatService().equals("nv")){   it.remove();   }
		    		if(ss.getEtatResteau().equals("nv") && ss.getEtatService().equals("x")){   it.remove();   }
		    		
		    		
		    		if((ss.getEtatResteau().equals("nv") || ss.getEtatResteau().equals("x")) && ss.getEtatService().equals("v")){     
		    		
		    			for(Iterator<Ligne_Commande> iterator = ss.getLigne_commande().iterator(); iterator.hasNext();)
		    			{

		    				Ligne_Commande s = iterator.next();
		    	            if(   s.getType().equals("resteau")       )
		    	            	
		    	            {   iterator.remove()  ;  
		    	            			

		    	            }
		    			}
		    			
		    			
		    			if(ss.getLigne_commande().isEmpty()) {it.remove() ;}
		    			
		    		} 
		    		
                  
		    	   if(ss.getEtatResteau().equals("v") && (ss.getEtatService().equals("nv") || ss.getEtatService().equals("x"))){     
			    		
		    			for(Iterator<Ligne_Commande> iterator = ss.getLigne_commande().iterator(); iterator.hasNext();)
		    			{

		    				Ligne_Commande s = iterator.next();
		    	            if(  ! s.getType().equals("resteau")       )
		    	            	
		    	            {   iterator.remove()  ;  
		    	            			

		    	            }
		    			}
		    			
		    			
		    			if(ss.getLigne_commande().isEmpty()) {it.remove() ;}
		    			
		    		} }
		    	   
		    	   
		    	   
		    	   
		    	   
		    	   
		    	   return lc;   } 
	           return null;
	             
	 }
		catch (Exception e) {  e.printStackTrace(); }

	      return null;
}



}
