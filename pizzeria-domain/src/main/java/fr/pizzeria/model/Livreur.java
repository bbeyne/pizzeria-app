package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="livreur")
public class Livreur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@OneToMany(mappedBy="livreur")
	private Set<Commande> commandes;

	public Livreur(String nom, String prenom) {
		super();
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	public String toString(){
		return (prenom +" "+nom);
		
	}
	public Livreur(){
		
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
