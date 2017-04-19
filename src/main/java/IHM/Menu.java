package fr.pizzeria.IHM;


import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.Dao.PizzaDaoImpl;
public class Menu {
	
	public boolean menu(List<Pizza> pizza) {
		PizzaDaoImpl daoimpl = new PizzaDaoImpl(pizza);
		int a =0;		
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		OptionMenu opt= new OptionMenu(daoimpl);
		while (a!=99){
			menuaffich(daoimpl);
			a = questionUser.nextInt();
			opt.option(a);
		}
		 questionUser.close();
		 return true;

	}
	private static void menuaffich(PizzaDaoImpl daoimpl) {
		ListerPizzasOptionMenu listage = new ListerPizzasOptionMenu(daoimpl);	
		NouvellePizzaOptionMenu ajout = new NouvellePizzaOptionMenu(daoimpl);
		ModifPizzaOptionMenu modif = new ModifPizzaOptionMenu(daoimpl);
		SuppPizzaOptionMenu supp = new SuppPizzaOptionMenu(daoimpl);
		System.out.println("    ***** Pizzeria Administration *****");
		System.out.println(listage.libelle);
		System.out.println(ajout.libelle);
		System.out.println(modif.libelle);
		System.out.println(supp.libelle);
		System.out.println("99. Sortir ");
	}

}
