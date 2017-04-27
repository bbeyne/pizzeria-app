package fr.pizzeria.dao.jpa;

import javax.persistence.Persistence;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IPizzaDao;

public class DaoJpaFactory implements DaoFactory{
private IPizzaDao pizzadao = new PizzaDaoJpa(Persistence.createEntityManagerFactory("pizzeria-unit"));
	public IPizzaDao getPizzaDao() {
		
		return pizzadao;
	}

}
