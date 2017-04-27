package fr.pizzeria.dao.JDBC;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoJdbcFactory implements DaoFactory{
	private IPizzaDao pizzaDao = new Jdbcversion();
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
