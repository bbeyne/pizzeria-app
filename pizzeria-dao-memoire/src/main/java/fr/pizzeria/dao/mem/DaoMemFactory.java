package fr.pizzeria.dao.mem;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoMemFactory implements DaoFactory{
	private IPizzaDao pizzaDao = null;
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
