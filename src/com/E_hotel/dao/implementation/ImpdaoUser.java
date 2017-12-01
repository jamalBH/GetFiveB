package com.E_hotel.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.E_hotel.dao.entites.User;

import com.E_hotel.dao.interfaces.IdaoUser;
import com.E_hotel.util.HibernateUtil;


public class ImpdaoUser implements IdaoUser{

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		
		List<User> users = new ArrayList<User>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		users = session.createQuery("from User where username=?")
				.setParameter(0, username).list();
		session.getTransaction().commit();
		System.out.println("wiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		if (users.size() > 0) {
			
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+users.get(0).getUsername());
			return users.get(0);
			
			
		} else {
			System.out.println("ouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuk");
			return null;
		}
		
		
		

	}

	@Override
	public void ajouter(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(user);
		session.getTransaction().commit();
		
	}
	}

	
