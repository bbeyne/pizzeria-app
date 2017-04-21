package fr.pizzeria.IHM;

import com.github.lalyos.jfiglet.FigletFont;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.Dao.DaoFactory;
import fr.pizzeria.Dao.DaoFichFactory;
import fr.pizzeria.Dao.IPizzaDao;
public class Menu {
	
	public boolean menu(List<Pizza> pizza) {
		DaoFactory daoimpl = new DaoFichFactory();
		int a =0;		
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		OptionMenu opt= new OptionMenu(daoimpl.getPizzaDao());
		while (a!=99){
			menuaffich(daoimpl.getPizzaDao());
			a = questionUser.nextInt();
			opt.option(a);
		}
		 questionUser.close();
		 return true;

	}
	private static void menuaffich(IPizzaDao daoimpl) {
		ListerPizzasOptionMenu listage = new ListerPizzasOptionMenu(daoimpl);	
		NouvellePizzaOptionMenu ajout = new NouvellePizzaOptionMenu(daoimpl);
		ModifPizzaOptionMenu modif = new ModifPizzaOptionMenu(daoimpl);
		SuppPizzaOptionMenu supp = new SuppPizzaOptionMenu(daoimpl);
		//try{
			String asciiArt = FigletFont.convertOneLine("PIZZERIA APP");
			System.out.println(asciiArt);
//		}catch (IOException e){
//			e.printStackTrace();
//		}

		System.out.println(listage.libelle);
		System.out.println(ajout.libelle);
		System.out.println(modif.libelle);
		System.out.println(supp.libelle);
		System.out.println("99. Sortir ");
	}

}
