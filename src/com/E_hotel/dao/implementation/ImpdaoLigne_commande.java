package com.E_hotel.dao.implementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.E_hotel.dao.entites.Ligne_Commande;
import com.E_hotel.dao.interfaces.IdaoLigne_commande;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoLigne_commande implements IdaoLigne_commande{

	@Override
	public void ajouter(Ligne_Commande ligne_commande) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(ligne_commande);
		session.getTransaction().commit();
		
	}

}
