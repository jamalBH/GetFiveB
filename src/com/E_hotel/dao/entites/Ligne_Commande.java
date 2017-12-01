package com.E_hotel.dao.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ligne_Commande implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	
	Integer id_Ligne_Commande ;
	Integer qte ;
	String name ;
    float prix ;
    String type ;
    
	
	@OneToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	Article article ;
	
	@ManyToOne(cascade= CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name = "id_commande")
	Commande commande ;

	
	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
	
	
	public Integer getId_Ligne_Commande() {
		return id_Ligne_Commande;
	}

	public void setId_Ligne_Commande(Integer id_Ligne_Commande) {
		this.id_Ligne_Commande = id_Ligne_Commande;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Ligne_Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
