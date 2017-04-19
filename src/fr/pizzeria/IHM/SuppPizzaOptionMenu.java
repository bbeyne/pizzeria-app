package fr.pizzeria.IHM;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.exception.ExceptionMauvaisCode;

public class SuppPizzaOptionMenu extends OptionMenu{
	public SuppPizzaOptionMenu(IPizzaDao dao) {
		super(dao);
		this.libelle="4. Supprimer une pizza ";
	}
	Scanner questionUser = new Scanner(System.in);
	public boolean execute(){
		questionUser.useLocale(Locale.US);
		System.out.println(" Veuillez choisir la pizza a supprimer");
		System.out.println("99 pour abandonner");
		String code = questionUser.next();
		try{
			dao.DeletePizza(code);
		} catch (ExceptionMauvaisCode e){
			System.out.println("code erroné");
		}
		return true;
	}
}
