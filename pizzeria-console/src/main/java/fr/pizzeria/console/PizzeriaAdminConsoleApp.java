package fr.pizzeria.console;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;

import fr.pizzeria.IHM.Menu;
import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.model.Pizza;
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		String value = ResourceBundle.getBundle("application").getString("dao.impl");
		Menu menu= new Menu();		
		
		Class<?> maClasse = Class.forName(value);
		DaoFactory unObjet = (DaoFactory) maClasse.newInstance();
		List<Pizza> pizza = unObjet.getPizzaDao().findAllPizzas();
		

		menu.menu(pizza,unObjet.getPizzaDao());
	}
}