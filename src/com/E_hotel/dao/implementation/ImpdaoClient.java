package com.E_hotel.dao.implementation;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Client;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.interfaces.IdaoClient;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoClient implements IdaoClient{

	@Override
	public void ajouter(Client client) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(client);
		session.getTransaction().commit();
		
	}
	
	@Transactional
	public Client getById(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Client.class);
		
		Client client = (Client) cr.add(Restrictions.eq("id", id)).uniqueResult();
		
		session.close() ;
		return client;
	}

	@Override
	public Client getByUsername(String username) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Client.class);
		
		Client client = (Client) cr.add(Restrictions.eq("user", username)).uniqueResult();
		
		session.close() ;
		return client;
	}
	

public void modifier(Client client) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(session.merge(client));
		session.getTransaction().commit();
		
		return  ;	
	}
	
	
}
