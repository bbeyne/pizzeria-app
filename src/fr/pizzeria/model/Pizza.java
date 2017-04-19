package fr.pizzeria.model;

public class Pizza {

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
		
	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

		private int id;
		private String code;
		private String nom;
		private double prix;
		private CategoriePizza categorie;
		

		public Pizza(String code, String nom, double prix, CategoriePizza categorie){
			this.code=code;
			this.nom=nom;
			this.prix=prix;
			this.categorie=categorie;
		}
}
