package fr.pizzeria.client.IHM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

public class CommandeEnCours extends OptionMenuClient{

	public CommandeEnCours(EntityManagerFactory fact) {
		super(fact);
		this.libelle= "1. Commander une pizza";
	}

	public String getLibelle() {
		return libelle;
	}
	public boolean execute(Client client) {
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		EntityManager em=fact.createEntityManager();
		TypedQuery<Pizza> query2 = em.createQuery("select p from Pizza p", Pizza.class);
		Iterator<Pizza> iterator = query2.getResultList().iterator();
		while(iterator.hasNext()){
			Pizza pizza = iterator.next();
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " ("
					+ pizza.getPrix() + ") : "+ pizza.getCategorie());
		}
		int c=1;
		List<Pizza> pizzas = new ArrayList<>();
		while (c!=0){
			System.out.println("Taper un code Pizza ou taper 0 pour finir la commande");
			String code = questionUser.next();
			if (code.equals("0")){
				c=0;
			}
			else{
				Iterator<Pizza> iterator2 = query2.getResultList().iterator();
				while(iterator2.hasNext()){
					Pizza pizza = iterator2.next();
					if(pizza.getCode().equals(code)){
						pizzas.add(pizza);
					}
				}
			}
		}
		Date date =Calendar.getInstance().getTime();
		int numCommande = (int) date.getTime();
		TypedQuery<Livreur> query3 = em.createQuery("select p from Livreur p", Livreur.class);
		Livreur livreur = query3.getResultList().get(0);
		Commande commande=new Commande(numCommande, "NON TRAITE", date, client,livreur);
		commande.getPizzas().addAll(pizzas);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(commande);
		et.commit();
		return true;
	}
}
