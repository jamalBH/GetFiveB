package com.E_hotel.metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.bridge.ICommand;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.E_hotel.dao.entites.Article;
import com.E_hotel.dao.entites.Commande;
import com.E_hotel.dao.entites.Hotel;
import com.E_hotel.dao.entites.Ligne_Commande;
import com.E_hotel.dao.interfaces.IdaoChambre;
import com.E_hotel.dao.interfaces.IdaoCommande;
import com.E_hotel.dao.interfaces.IdaoLigne_commande;
import com.E_hotel.util.HibernateUtil;
import com.google.gson.Gson;

import service.CommandeParser;
import service.MyPojo;
import service.RetString;
import service.TokenManager;


public class CommandeMetier implements ICommandeMetier {

	
	@Autowired
	ArticleMetier articlemetier ;
	@Autowired
	TokenManager tokenmanager ;
	@Autowired
	ICompteMetier comptemetier  ;
	@Autowired
	HotelMetier hotelmetier ;
	@Autowired
	IdaoCommande daocommande  ;
	@Autowired
	IdaoLigne_commande daoligne_commande  ;
	@Autowired
	IdaoChambre daochambre ;  
	
	
	 
	
	 
	public void coverteJson(String json,Integer id_hotel ,String  username)  {
		Commande c = new Commande() ;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		c.setDate(dateFormat.format(date));
		c.setEtatResteau("x");
		c.setEtatService("x");
		 c.setClient(comptemetier.getClientByUsername(username));
	        c.setHotel(hotelmetier.getImpdaoHotel().getById(id_hotel));
	        c.setChambre(daochambre.getByClient(username));
	        daocommande.ajouter(c);
	        
		Ligne_Commande ligne_commande= new Ligne_Commande(); 
		List<Ligne_Commande> list_ligne_commande  =  new ArrayList<Ligne_Commande>() ;
        MyPojo data = new Gson().fromJson(json, MyPojo.class);
        
        for(int i=0 ; i<data.getCommandeParser().size() ; i++)
        {
        	ligne_commande.setArticle(articlemetier.getArticleById(data.getCommandeParser().get(i).getId()));
        	ligne_commande.setQte(data.getCommandeParser().get(i).getQte());
        	ligne_commande.setName(data.getCommandeParser().get(i).getName());
        	ligne_commande.setPrix(data.getCommandeParser().get(i).getPrix());
        	ligne_commande.setType(data.getCommandeParser().get(i).getType());
        	list_ligne_commande.add(ligne_commande) ;
        	ligne_commande.setCommande(c);

        	 daoligne_commande.ajouter(ligne_commande);
        	
        }
 
       
        
        return  ;
		
	
	}





	@Override
	public List<Commande> getCommandeByHotel(Integer idhotel) {
		// TODO Auto-generated method stub
		return null;
	}


	public void  validerEtatResteau(Integer id_commande) {
		
		Commande commande = daocommande.getById(id_commande) ;
		commande.setEtatResteau("v");
		
		daocommande.modifierEtat(commande);
		
		return  ;	
	}
	
public void  anullerEtatResteau(Integer id_commande) {
		
		Commande commande = daocommande.getById(id_commande) ;
		commande.setEtatResteau("nv");
		
		daocommande.modifierEtat(commande);
		
		return  ;	
	}
	
public void  validerEtatService(Integer id_commande) {
		
	Commande commande = daocommande.getById(id_commande) ;
	commande.setEtatService("v");
	
	daocommande.modifierEtat(commande);
	
	return  ;		
		
	}
public void  anullerEtatService(Integer id_commande) {
	
	Commande commande = daocommande.getById(id_commande) ;
	commande.setEtatService("nv");
	
	daocommande.modifierEtat(commande);
	
	return  ;	}





	

  
  
  
  

  
  
  
  
	
}






