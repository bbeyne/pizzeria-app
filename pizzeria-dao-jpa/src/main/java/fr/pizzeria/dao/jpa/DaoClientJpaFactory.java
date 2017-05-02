package fr.pizzeria.dao.jpa;

import javax.persistence.Persistence;

import fr.pizzeria.dao.DaoClientFactory;
import fr.pizzeria.dao.IClientDao;

public class DaoClientJpaFactory implements DaoClientFactory{
	private IClientDao clientdao = new ClientDaoJpa(Persistence.createEntityManagerFactory("pizzeria-client"));
	public DaoClientJpaFactory(IClientDao clientdao) {
	super();
	this.clientdao = clientdao;
}
	public IClientDao getClientDao() {
		
		return clientdao;
	}

}
