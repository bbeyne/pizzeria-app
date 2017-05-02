package fr.pizzeria.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.model.Client;

public class ClientDaoJpa implements IClientDao{
	EntityManagerFactory fact;


	public ClientDaoJpa(EntityManagerFactory fact) {
		super();
		this.fact = fact;
	}

	public List<Client> findAllClients() {
		EntityManager em=fact.createEntityManager();
		TypedQuery<Client> query2 = em.createQuery("select client from Client client", Client.class);
		return query2.getResultList();
	}

	public boolean SaveNewClient(Client client) {

		EntityManager em=fact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(client);
		et.commit();
		em.close();
		return false;
	}

	public boolean UpdateClient(String mail, Client client) throws ExceptionMauvaisCode {

		EntityManager em=fact.createEntityManager();
		Query query =em.createQuery("select c from Client c where c.email=:mail", Client.class);
		query.setParameter("mail", mail);
		Client cl = (Client) query.getResultList().get(0);
		EntityTransaction et = em.getTransaction();
		et.begin();
		if(cl != null){
			cl.setPrenom(client.getPrenom());
			cl.setAdresse(client.getAdresse());
			cl.setNom(client.getNom());
			cl.setMdp(client.getMdp());
			cl.setEmail(client.getEmail());
		}
		et.commit();
		em.close();
		return false;
	}

	public boolean DeleteClient(String mail) throws ExceptionMauvaisCode {
		EntityManager em=fact.createEntityManager();
		Query query =em.createQuery("select c from Client c where c.email=:mail", Client.class);
		query.setParameter("mail", mail);
		Client cl = (Client) query.getResultList().get(0);
		EntityTransaction et = em.getTransaction();
		et.begin();
		if(cl != null){
			em.remove(cl);
		}
		et.commit();
		em.close();
		return false;
	}
	
}
