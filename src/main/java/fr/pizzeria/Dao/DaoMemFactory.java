package fr.pizzeria.Dao;

public class DaoMemFactory implements DaoFactory{
	private IPizzaDao pizzaDao = null;
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
