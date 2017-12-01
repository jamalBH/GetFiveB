package com.E_hotel.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.E_hotel.dao.entites.UserRole;
import com.E_hotel.dao.interfaces.IdaoUserRole;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoUserRole implements IdaoUserRole{

	
	
	@Override
	public void ajouter(UserRole userRole) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(userRole);
		session.getTransaction().commit();
	}
}
