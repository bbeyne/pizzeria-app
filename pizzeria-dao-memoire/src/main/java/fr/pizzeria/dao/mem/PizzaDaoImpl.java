package fr.pizzeria.dao.mem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDao {
	public List<Pizza> pizzas;

	public PizzaDaoImpl(List<Pizza> pizza) {
		this.pizzas = pizza;
	}

	public PizzaDaoImpl() {
		List<Pizza> pizza = new ArrayList<Pizza>();
		pizza.add(new Pizza("PEP", "PEPERONI", 12.50, CategoriePizza.valueOf("VIANDE")));
		pizza.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.valueOf("SANS_VIANDE")));
		pizza.add(new Pizza("REI", "La Reine", 11.50,CategoriePizza.valueOf("VIANDE")));
		pizza.add(new Pizza("FRO", "La 4 fromages", 12.00,CategoriePizza.valueOf("SANS_VIANDE")));
		pizza.add(new Pizza("CAN", "La cannibale", 12.50,CategoriePizza.valueOf("VIANDE")));
		pizza.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.valueOf("VIANDE")));
		pizza.add(new Pizza("ORI", "L'orientale", 13.50,CategoriePizza.valueOf("VIANDE")));
		pizza.add(new Pizza("IND", "L'indienne", 14.00,CategoriePizza.valueOf("VIANDE")));
		pizza.add(new Pizza("NOR", "La Norvegienne",15.00, CategoriePizza.valueOf("POISSON")));
		this.pizzas = pizza;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean SaveNewPizza(Pizza pizza) {
		pizzas.add(pizza);
		return false;
	}

	@Override
	public boolean UpdatePizza(String codePizza, Pizza pizza) throws ExceptionMauvaisCode {
		if (!codePizza.equals("99")) {
			Iterator<Pizza> iterator = pizzas.iterator();
			Pizza pizzait = iterator.next();
			while (iterator.hasNext() && (!pizzait.getCode().equals(codePizza))) {
				pizzait = iterator.next();
			}

			// while ((j<nbpizza) && (!pizzas[j].getCode().equals(codePizza)) ){
			// j+=1;
			// }
			if (!pizzait.getCode().equals(codePizza)) {
				throw new ExceptionMauvaisCode();
			}
			pizzait.setCode(pizza.getCode());
			pizzait.setNom(pizza.getNom());
			pizzait.setPrix(pizza.getPrix());
			pizzait.setCategorie(pizza.getCategorie());
		}

		return false;
	}

	@Override
	public boolean DeletePizza(String codePizza) throws ExceptionMauvaisCode {
		if (!codePizza.equals("99")){
			Iterator<Pizza> iterator = pizzas.iterator();
			Pizza pizzait = iterator.next();
			Pizza pizzaind=pizzait;
			while(iterator.hasNext() && (!pizzait.getCode().equals(codePizza))){
				pizzait = iterator.next();
				pizzaind=pizzait;
				if (pizzait.getCode().equals(codePizza)){
					while(iterator.hasNext()){
						pizzaind = iterator.next();
						pizzaind.setId(pizzaind.getId()-1);
					}
				}
			}
			if (!pizzait.getCode().equals(codePizza)){
				throw new ExceptionMauvaisCode();
			}
			pizzas.remove(pizzait);
		}
		return false;
	}

}
