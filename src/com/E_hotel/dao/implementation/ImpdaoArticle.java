package com.E_hotel.dao.implementation;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Article;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.interfaces.IdaoArticle;
import com.E_hotel.util.HibernateUtil;


public class ImpdaoArticle implements IdaoArticle{
	
	@Override
	public void ajouter(Article article) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(article);
		session.getTransaction().commit();
		
	}

	@Transactional
	public Article getArticleById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Article.class);
		
		Article article = (Article) cr.add(Restrictions.eq("id_article", id)).uniqueResult();
		
		session.close() ;
		return article;
	}
	
	

}
