package fr.pizzeria.model;

import javax.persistence.*;

@Entity
@Table(name="pizzas")
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
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		@Column(name="code")
		private String code;
		@Column(name="libelle")
		private String nom;
		@Column(name="prix")
		private double prix;
		@Column(name="categorie")
		@Enumerated(EnumType.STRING)
		private CategoriePizza categorie;
		
		public String toString(){
			return (code+" "+nom+" "+prix+" "+categorie);
			
		}
		public Pizza() {
			super();
		}

		public Pizza(String code, String nom, double prix, CategoriePizza categorie){
			this.code=code;
			this.nom=nom;
			this.prix=prix;
			this.categorie=categorie;
		}
}
