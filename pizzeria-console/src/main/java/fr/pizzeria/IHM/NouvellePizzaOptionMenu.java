package fr.pizzeria.IHM;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {

	public NouvellePizzaOptionMenu(IPizzaDao dao) {
		super(dao);
		this.libelle = "2. Ajouter une nouvelle pizza";
	}

	public boolean execute() {
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		System.out.println(" Donner le code de la pizza ");
		String code = questionUser.next();
		System.out.println(" Donner le nom de la pizza ");
		String nom = questionUser.next();
		System.out.println(" Donner le prix de la pizza ");
		double prix = questionUser.nextDouble();
		System.out.println("VIANDE, POISSON, SANS_VIANDE ??? ");
		String cat = questionUser.next();
		Pizza pizza= new Pizza(code, nom, prix, CategoriePizza.valueOf(cat));
		dao.SaveNewPizza(pizza);
		return true;
	}
}
