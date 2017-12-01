package com.E_hotel.form;


import javax.validation.constraints.Size;

public class ArticleForm {

	private Integer id_categ;
	@Size(min=2,max=28)
	private String nom_article;
	
	private float prix_article;
	@Size(max=150)
	private String description;
	private String image;
	
	
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public float getPrix_article() {
		return prix_article;
	}
	public void setPrix_article(float prix_article) {
		this.prix_article = prix_article;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public Integer getId_categ() {
		return id_categ;
	}
	public void setId_categ(Integer id_categ) {
		this.id_categ = id_categ;
	}

	
	
}
