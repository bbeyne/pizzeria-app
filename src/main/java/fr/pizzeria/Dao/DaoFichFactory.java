package fr.pizzeria.Dao;

public class DaoFichFactory implements DaoFactory{
private static final String dataDir = "Data";
private IPizzaDao pizzaDao = new PizzaDaoImplFichier(dataDir);
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
