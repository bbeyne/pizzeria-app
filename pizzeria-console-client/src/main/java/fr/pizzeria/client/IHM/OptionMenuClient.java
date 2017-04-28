package fr.pizzeria.client.IHM;

import javax.persistence.EntityManagerFactory;

public class OptionMenuClient {
		public EntityManagerFactory fact;
		
		public String libelle;
		
		public OptionMenuClient(EntityManagerFactory fact) {
			super();
			this.fact = fact;
		}
	
}
