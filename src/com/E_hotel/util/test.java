package com.E_hotel.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.E_hotel.dao.entites.Article_categorie;
import com.E_hotel.dao.entites.Chambre;
import com.E_hotel.dao.entites.Chambre_categorie;
import com.E_hotel.dao.entites.Client;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.Menu;
import com.E_hotel.dao.entites.Reservation;
import com.E_hotel.dao.entites.User;
import com.E_hotel.dao.implementation.ImpdaoArticleCategorie;
import com.E_hotel.dao.implementation.ImpdaoChambre;
import com.E_hotel.dao.implementation.ImpdaoChambre_categorie;
import com.E_hotel.dao.implementation.ImpdaoClient;
import com.E_hotel.dao.implementation.ImpdaoHotel;
import com.E_hotel.dao.implementation.ImpdaoMenu;
import com.E_hotel.dao.implementation.ImpdaoReservation;
import com.E_hotel.dao.implementation.ImpdaoUser;
import com.E_hotel.dao.interfaces.IdaoChambre;
import com.E_hotel.dao.interfaces.IdaoChambre_categorie;
import com.E_hotel.dao.interfaces.IdaoHotel;
import com.E_hotel.form.ChambreForm;
import com.E_hotel.metier.ChambreMetier;
import com.E_hotel.metier.CompteMetier;
import com.E_hotel.metier.IChambreMetier;
import com.E_hotel.metier.ICompteMetier;

public class test {
   
	public static void main(String[] args)  {
	
//		ICompteMetier m = (ICompteMetier) new CompteMetier() ;
//		
//		Client c = m.getClient("1");
//		System.out.println(c.getNom());
//		
	//	ICompteMetier m = (ICompteMetier) new CompteMetier() ;
	//	if (m.isExist("younesss") ) {System.out.println(m.isExist("youness"));}
	//	else {System.out.println("not exist");}
		
		
//	ImpdaoChambre_categorie imp = new ImpdaoChambre_categorie() ;
//		
//		System.out.println("/n");
//		System.out.println(imp.findAllCategoriesByHotel(1).get(0).getNom_chambre_categorie());
//		ChambreForm chambreForm = new ChambreForm();
//		chambreForm.setN_chambre("22");
//		ChambreMetier chambreMetier = (ChambreMetier) new ChambreMetier();
//		chambreMetier.addChambre(chambreForm);
//		
//	

	
	//	idh.ajouter(h);
		
		
	/*	
		Chambre c = new Chambre() ;
		c.setN_chambre("ddd");
		IdaoChambre dc =(IdaoChambre) new ImpdaoChambre() ;
		dc.ajouter(c);

		
  /*         IdaoHotel daohotel = (IdaoHotel) new ImpdaoHotel();
        daohotel.supprimerById(1);
		//  System.out.print(h.getAddress_hotel());
	/*	SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.getCurrentSession();
		session.beginTransaction();		
		
		Criteria cr = session.createCriteria(Chambre.class ) ;
		cr.add(Restrictions.like("chambre_categorie.description","%3%"));
		
		Chambre chambre = (Chambre) cr.list().get(0);
		System.out.print(chambre.getN_chambre());
		
	/*	Chambre_categorie chc = new Chambre_categorie();
		
			chc.setDescription("chambre de 3 perssones");
			
			IdaoChambre_categorie addchc = (IdaoChambre_categorie) new ImpdaoChambre_categorie();
			addchc.ajouterbyhotel(chc, 1);	
		
		
	/*	IdaoHotel idh =(IdaoHotel) new ImpdaoHotel() ;
		Hotel h = idh.identifier("ibis") ;
		System.out.print(h.getNom_hotel());
		
		
	/*	Hotel h = new Hotel() ;
		h.setNom_hotel("Ibis");
		h.setAddress_hotel("Hay sisdi youssef");
		h.setTel_hotel("0621297680");
		h.setVille_hotel("agadir");
		h.setClasse_hotel("5 star");
		h.setPasse_hotel("ibisibis2017");
		
		IdaoHotel idh =(IdaoHotel) new ImpdaoHotel() ;
		idh.ajouter(h);
		
		Chambre_categorie chc = new Chambre_categorie();
	//	chc.setId_chambre_categorie(2);
		chc.setDescription("chebre 2 perssone");
		
		Chambre c = new Chambre() ;
		c.setN_chambre("N775");
	    c.setChambre_categorie(chc);
		
	    Chambre cc = new Chambre() ;
		//	cc.setId_chambre(19);
			cc.setN_chambre("N975");
		    cc.setChambre_categorie(chc);

		IdaoChambre addc = (IdaoChambre) new ImpdaoChambre() ;
		addc.ajouter(c);
		addc.ajouter(cc);
	
		
		
	/*	IChambre_categorie addchc = (IChambre_categorie) new ImpChambre_categorie();
		addchc.ajouter(chc);
		*/
		
		
	
		
		
		
		/*	Chambre c = new Chambre() ;
		c.setId_chambre(17);
		c.setN_chambre("N55");
		
		IChambre addc = (IChambre) new ImpChambre() ;
		addc.ajouter(c);
		
		
	/*	
		
		Chambre c = new Chambre() ;
		c.setId_chambre(17);
		c.setN_chambre("N55");
		c.setChambre_categorie(chc);
		IChambre addc = (IChambre) new ImpChambre() ;
		addc.ajouter(c);
		
	/*	Hotel h = new Hotel() ;
		h.setId_hotel(6);
		h.setNom_hotel("Marjana");
		h.setClasse_hotel("5 star");
		h.setTel_hotel("0665748290");
		h.setAddress_hotel("1001 Mansour");
		h.setPasse_hotel("10011001");
		
		IHotel addh = (IHotel) new ImpHotel() ;
		addh.ajouter(h); 
			
	/*	Chambre_categorie chc = new Chambre_categorie();
		chc.setId_chambre_categorie(1);
		chc.setDescription("chebre 1 perssone");
		
		Chambre c = new Chambre() ;
		c.setId_chambre(99);
		c.setN_chambre("N55");
		c.setChambre_categorie(chc);
		c.setHotel(h);
		IChambre addc = (IChambre) new ImpChambre();
		addc.ajouter(c);
	*/
		
	/*		IHotel addh = (IHotel) new ImpHotel() ;
		addh.ajouter(h); */
		
	  /*  IHotel fh = (IHotel) new ImpHotel() ;
		Hotel h = new Hotel() ;
		h =( Hotel) fh.identifier("yen2008pvnrt8.314");
		System.out.print(h.getNom_hotel()); */
		
		

	}

}
