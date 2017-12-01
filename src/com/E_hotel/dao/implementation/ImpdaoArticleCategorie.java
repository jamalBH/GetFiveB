package com.E_hotel.dao.implementation;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Article_categorie;
import com.E_hotel.dao.entites.Menu;
import com.E_hotel.dao.interfaces.IdaoArticleCategorie;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoArticleCategorie implements IdaoArticleCategorie{

	@Override
	public void ajouter(Article_categorie catArticle) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(catArticle);
		session.getTransaction().commit();
		
	}
	
	//RECHERCHE CATEGORIE BY ID============================================
	@Transactional
	public Article_categorie getById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Article_categorie.class);
		
		Article_categorie articleCategorie = (Article_categorie) cr.add(Restrictions.eq("idArticleCategorie", id)).uniqueResult();
		
		session.close() ;
		return articleCategorie;
	}
	
	
public List<Article_categorie> findAllCategoriesByMenu(Integer idMenu){
		
		try{
   	     List<Article_categorie> categories ;
   	     SessionFactory sf = HibernateUtil.getSessionFactory();
   		 Session session = sf.getCurrentSession();
   		 session.beginTransaction();
   		 Criteria cr = session.createCriteria(Article_categorie.class);
   			cr.add(Restrictions.eq("Menu.id", idMenu));
   			categories = (List<Article_categorie>) cr.list() ;
   		session.getTransaction().commit();	
   			
   			if(categories.size() > 0){
   	        return categories;}
   			
   			
   			return null;
   	     }catch (Exception e) {
			 System.out.println("");
			 
   	     }
		return null;
			
	}
	
	
public List<Article_categorie> findAllCategories(){
		
		try{
   	     List<Article_categorie> categories ;
   	     SessionFactory sf = HibernateUtil.getSessionFactory();
   		 Session session = sf.getCurrentSession();
   		 session.beginTransaction();
   		 Criteria cr = session.createCriteria(Article_categorie.class);
   			
   			categories = (List<Article_categorie>) cr.list() ;
   		session.getTransaction().commit();	
   			
   			if(categories.size() > 0){
   	        return categories;}
   			
   			
   			return null;
   	     }catch (Exception e) {
			 System.out.println("");
			 
   	     }
		return null;
			
	}
}
