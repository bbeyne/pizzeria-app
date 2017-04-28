package fr.pizzeria.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="commande")
public class Commande {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int id;
	@Column(name="numero_commande")
	private int numCommande;
	@Column(name="statut")
	private String statut;
	@Column(name="date_commande")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name="livreur_id")
	private Livreur livreur;
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	@ManyToMany
	@JoinTable(name="commande_pizza",joinColumns=
	@JoinColumn(name="commande_id", referencedColumnName="id"),inverseJoinColumns=
	@JoinColumn(name="pizzas_id", referencedColumnName="id")
	)
	private Set<Pizza> pizzas=new HashSet<>(0);
	
	public Commande(int numCommande, String statut, Date dateCommande, Client client, Livreur livreur) {
		super();
		this.numCommande = numCommande;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.client = client;
		this.livreur=livreur;
	}
	public Commande() {
		super();
	}
	public String toString(){
		return (statut +" "+numCommande+" "+dateCommande+" "+livreur+" "+ client);
		
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Livreur getLivreur() {
		return livreur;
	}
	public void setLivreurId(Livreur livreurId) {
		this.livreur = livreurId;
	}
	public Client getClientId() {
		return client;
	}
	public void setClientId(Client clientId) {
		this.client = clientId;
	}
	public int getId() {
		return id;
	}
	public int getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(int numCommande) {
		this.numCommande = numCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Set<Pizza> getPizzas() {
		return pizzas;
	}
	public void setPizzas(Set<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
}
