package fr.pizzeria.Dao;

public class DaoMemFactory implements DaoFactory{
	private IPizzaDao pizzaDao = new PizzaDaoImpl();
	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
