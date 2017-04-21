package fr.pizzeria.IHM;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifPizzaOptionMenu extends OptionMenu{
	
	public ModifPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
		this.libelle="3. Mettre a jour une pizza ";
	}
	Scanner questionUser = new Scanner(System.in);
	
	
	public boolean execute() {
		questionUser.useLocale(Locale.US);
		System.out.println(" Veuillez choisir la pizza a modifier");
		System.out.println("99 pour abandonner");
		String code = questionUser.next();
		System.out.println(" Veuillez saisir le code");
		String codemodif = questionUser.next();
		System.out.println("Veuillez saisir le nom");
		String nommodif = questionUser.next();
		System.out.println(" veuillez saisir le prix");
		double prixmodif = questionUser.nextDouble();
		System.out.println(" VIANDE, POISSON, SANS_VIANDE ??? ");
		String cat = questionUser.next();
		Pizza pizza= new Pizza(codemodif, nommodif, prixmodif, CategoriePizza.valueOf(cat));
		try{
			dao.UpdatePizza(code, pizza);
			} catch (ExceptionMauvaisCode e){
				System.out.println("erreur dans le code");
	}
		return true;
	}
}
