package fr.pizzeria.IHM;

import java.util.Iterator;
import java.util.ResourceBundle;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.fich.DaoFichFactory;
import fr.pizzeria.model.Pizza;

public class ImportDonnees extends OptionMenu {

	public ImportDonnees(IPizzaDao dao) {
		super(dao);
		this.libelle = "5. (Base de données) Importer les données";
	}

	public boolean execute() {
		if (!ResourceBundle.getBundle("application").getString("dao.impl")
				.equals("fr.pizzeria.dao.JDBC.DaoJdbcFactory"))

			System.out.println("Veuillez configurer l’application avec une implémentation base de données.");
		else {
			DaoFichFactory daofich = new DaoFichFactory();
			Iterator<Pizza> iterator2 = daofich.getPizzaDao().findAllPizzas().iterator();
			while (iterator2.hasNext()) {
					dao.SaveNewPizza(iterator2.next());
				}
			}

		return true;
	}

}
