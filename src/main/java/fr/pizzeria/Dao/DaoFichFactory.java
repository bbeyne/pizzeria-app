package fr.pizzeria.Dao;

public class DaoFichFactory implements DaoFactory{
private static final String dataDir = "C:/Users/ETY/Documents/workspace-sts-3.8.3.RELEASE/pizzeria-console-objet/data";
public static String getDataDir() {
	return dataDir;
}
private IPizzaDao pizzaDao = new PizzaDaoImplFichier(dataDir);
	@Override
	public IPizzaDao getPizzaDao() {
		// TODO Auto-generated method stub
		return pizzaDao;
	}

}
