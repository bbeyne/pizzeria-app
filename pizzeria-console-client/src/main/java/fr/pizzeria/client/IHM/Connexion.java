package fr.pizzeria.client.IHM;

import java.util.Locale;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.model.Client;

public class Connexion extends OptionMenuClient{
	
	public Connexion(EntityManagerFactory fact) {
		super(fact);
		this.libelle="2. Se connecter";
	}
	public String getLibelle() {
		return libelle;
	}
	public boolean execute() {
		Scanner questionUser = new Scanner(System.in);
		questionUser.useLocale(Locale.US);
		System.out.println("Ecrire votre mail ");
		String mail = questionUser.next();
		System.out.println("Ecrire votre mot de passe");
		String mdp = questionUser.next();
		EntityManager em=fact.createEntityManager();
		Query query =em.createQuery("select p from Client p where p.email=:mail AND p.mdp=:mdp", Client.class);
		query.setParameter("mail", mail);
		query.setParameter("mdp", DigestUtils.sha1Hex(mdp));
		
		if (query.getResultList().isEmpty()){
			System.out.println("erreur dans le mail ou le mdp");
		}
		else{
			Client client=(Client) query.getResultList().get(0);
			CommandeEnCours comm = new CommandeEnCours(fact);
			System.out.println("***** Pizzeria Client *****");
			System.out.println(comm.getLibelle());
			System.out.println("2. Lister ses commandes");
			System.out.println("99. Sortir");
			int a = questionUser.nextInt();
			if (a==1)	comm.execute(client);
			if (a==2)	client.getCommandes();
		}
		em.close();
		return true;
	}
}
