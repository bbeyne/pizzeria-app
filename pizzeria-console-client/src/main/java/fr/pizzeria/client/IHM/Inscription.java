package fr.pizzeria.client.IHM;

import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManagerFactory;
import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.model.Client;
import fr.pizzeria.dao.jpa.*;

public class Inscription extends OptionMenuClient{

	public Inscription(EntityManagerFactory fact) {
		super(fact);
		this.libelle = "1. S'inscrire";
	}
	public String getLibelle() {
		return libelle;
	}
	public boolean execute() {
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		System.out.println(" Ecrire votre nom ");
		String nom = questionUser.next();
		System.out.println(" Ecrire votre prenom ");
		String prenom = questionUser.next();
		System.out.println(" Ecrire votre adresse ");
		String adresse = questionUser.next();
		System.out.println("Ecrire votre mail ");
		String mail = questionUser.next();
		System.out.println("Ecrire votre mot de passe");
		String mdp = questionUser.next();
		Client client = new Client(nom, prenom, adresse, mail, DigestUtils.sha1Hex(mdp));
		ClientDaoJpa cl = new ClientDaoJpa(fact);
		cl.SaveNewClient(client);
		return true;
	}
}
