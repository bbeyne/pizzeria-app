package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="adresse")
	private String adresse;
	@Column(name="email")
	private String email;
	@Column(name="mdp")
	private String mdp;
	@OneToMany(mappedBy="client")
	private Set<Commande> commandes;

	public Client(String nom, String prenom, String adresse, String email, String mdp) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setEmail(email);
		this.setMdp(mdp);
	}
	public String toString(){
		return (prenom +" "+nom+" "+adresse+" "+email+" "+mdp);
		
	}
	public Client(){
	}	
	public Set<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	public int getId() {
		return id;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}
