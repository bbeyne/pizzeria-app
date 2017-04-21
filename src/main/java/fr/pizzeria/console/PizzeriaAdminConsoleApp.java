package fr.pizzeria.console;
import java.util.List;

import fr.pizzeria.Dao.DaoFactory;
import fr.pizzeria.Dao.DaoFichFactory;
import fr.pizzeria.Dao.DaoMemFactory;
import fr.pizzeria.IHM.Menu;
import fr.pizzeria.model.Pizza;;
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoFactory daoFactory = new DaoFichFactory();
		List<Pizza> pizza = daoFactory.getPizzaDao().findAllPizzas();
		Menu menu= new Menu();
		menu.menu(pizza,daoFactory);
	}
}