package com.E_hotel.form;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class HotelForm {

	private Integer idHotel;
	
	@Size(min=2,max=40,message = "Entrez le Nom d'hotel SVP!")
	private String nom;
	
	@Size(min=2,max=10,message = "Entrez un nom d'utilisateur correct!")
	private String username;
	
	@Size(min=2,max=20,message = "Entrez la ville correct d'hotel!")
	private String ville;

	@Size(min=2,max=100,message = "Entrez l'adresse correct d'hotel SVP!")
	private String adresse;
	
	private String paye;
    @NotNull(message="Specifier votre classe SVP!")
	private String classe;

	@Size(min=2,max=40,message = " N° de Telephone Invalid!")
	@Pattern(regexp="(^$|[0-9]{10})")
	private String tel;

	@Size(min=2,max=40,message = "Entrez le mot de passe SVP!")
	private String password;
	
	
	private String image;
	
	private String description;
	
	private String role;
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public HotelForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getIdHotel() {
		return idHotel;
	}
	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}
	public String getPaye() {
		return paye;
	}
	public void setPaye(String paye) {
		this.paye = paye;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
