package fr.pizzeria.console.client;

import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fr.pizzeria.client.IHM.Connexion;
import fr.pizzeria.client.IHM.Inscription;


public class PizzeriaClient {

	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		EntityManagerFactory fact= Persistence.createEntityManagerFactory("pizzeria-client");
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		Inscription opt1 = new Inscription(fact);
		Connexion opt2 = new Connexion(fact);
		System.out.println("***** PIZERIA CLIENT *****");
		System.out.println(opt1.getLibelle());
		System.out.println(opt2.getLibelle());
		System.out.println("99. Quitter");
		int a = questionUser.nextInt();
		if (a==1)	opt1.execute();
		if (a==2) 	opt2.execute();
		questionUser.close();
	}

}
