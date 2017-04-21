package fr.pizzeria.IHM;

import fr.pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.Iterator;
import fr.pizzeria.dao.IPizzaDao;
public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(IPizzaDao dao) {
		super(dao);
		this.libelle = "1. Lister les pizzas";	
	}

	public boolean execute() {
		
		ArrayList<Pizza> pizzas=(ArrayList<Pizza>) dao.findAllPizzas();
		Iterator<Pizza> iterator = pizzas.iterator();
		while(iterator.hasNext()){
			Pizza pizza = iterator.next();
			System.out.println(pizza.getCode() + " -> " + pizza.getNom() + " ("
					+ pizza.getPrix() + ") : "+ pizza.getCategorie());
		}
		System.out.println(" ");
		return true;
	}

}
