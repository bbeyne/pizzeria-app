package fr.pizzeria.Dao;

import java.util.List;

import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	
	List<Pizza> findAllPizzas();
	boolean SaveNewPizza(Pizza pizza);
	boolean UpdatePizza(String codePizza, Pizza pizza) throws ExceptionMauvaisCode;
	boolean DeletePizza(String codePizza) throws ExceptionMauvaisCode;
	
}
