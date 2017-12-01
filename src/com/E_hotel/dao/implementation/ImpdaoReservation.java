package com.E_hotel.dao.implementation;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Reservation;
import com.E_hotel.dao.interfaces.IdaoReservation;
import com.E_hotel.util.HibernateUtil;

public class ImpdaoReservation implements IdaoReservation{

	@Override
	public void ajouter(Reservation reservation) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		session.save(reservation);
		session.getTransaction().commit();
		
		
	}
	
	public void modifier(Reservation r) {
		
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		
		session.saveOrUpdate(session.merge(r));
		session.getTransaction().commit();
		
	}
	
	
	@Transactional
	public Reservation getByChambreActive(Integer id) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Reservation.class);
		//cr.add(Restrictions.eq("chambre.status", true));
		cr.add(Restrictions.eq("chambre.id_chambre", id));
		Reservation reservation = (Reservation) cr.list().get(cr.list().size() - 1);
		session.close() ;
		return reservation;
	}
	
	@Transactional
	public Reservation getByIdClient(Integer idclient) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Reservation.class);
		cr.add(Restrictions.eq("status", true));
		cr.add(Restrictions.eq("client.id", idclient));
		Reservation reservation = (Reservation) cr.list().get(0);
		session.close() ;
		return reservation;
	}
	
	
	
}
