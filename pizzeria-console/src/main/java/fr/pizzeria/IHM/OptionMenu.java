package fr.pizzeria.IHM;

import fr.pizzeria.dao.IPizzaDao;

public class OptionMenu {
		public IPizzaDao dao;
		public String libelle;
		
		public OptionMenu(IPizzaDao dao){
			this.dao=dao;
		}
		
		public boolean option(int a){
			ListerPizzasOptionMenu listage = new ListerPizzasOptionMenu(dao);
			if (a==1){
				listage.execute();
			}
			if (a==2){
				NouvellePizzaOptionMenu ajout = new NouvellePizzaOptionMenu(dao);
				ajout.execute();
			}
			if (a==3){
				listage.execute();
				ModifPizzaOptionMenu modif = new ModifPizzaOptionMenu(dao);
				modif.execute();
			}
			if (a==4){
				listage.execute();
				SuppPizzaOptionMenu supp = new SuppPizzaOptionMenu(dao);
				supp.execute();
			}
			if (a==5){
				ImportDonnees imp = new ImportDonnees(dao);
				imp.execute();
			}
			if (a==99){
				System.out.println(" Au revoir \uD83D\uDE23");
			}
			if ((a!=1)&&(a!=2)&&(a!=3)&&(a!=4)&&(a!=5)&&(a!=99)){
				System.out.println("choix erroné");
			}
			return true;
		}
}
