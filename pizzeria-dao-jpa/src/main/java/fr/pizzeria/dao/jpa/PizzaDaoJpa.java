package fr.pizzeria.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.model.Pizza;

public class PizzaDaoJpa implements IPizzaDao{
	EntityManagerFactory fact;


	public PizzaDaoJpa(EntityManagerFactory fact) {
		super();
		this.fact = fact;
	}

	public List<Pizza> findAllPizzas() {
		EntityManager em=fact.createEntityManager();
		TypedQuery<Pizza> query2 = em.createQuery("select p from Pizza p", Pizza.class);
		return query2.getResultList();
	}

	public boolean SaveNewPizza(Pizza pizza) {

		EntityManager em=fact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pizza);
		et.commit();
		em.close();
		return false;
	}

	public boolean UpdatePizza(String codePizza, Pizza pizza) throws ExceptionMauvaisCode {

		EntityManager em=fact.createEntityManager();
		Query query =em.createQuery("select p from Pizza p where p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		Pizza p = (Pizza) query.getResultList().get(0);
		EntityTransaction et = em.getTransaction();
		et.begin();
		if(p != null){
			p.setCategorie(pizza.getCategorie());
			p.setCode(pizza.getCode());
			p.setNom(pizza.getNom());
			p.setPrix(pizza.getPrix());
		}
		et.commit();
		em.close();
		return false;
	}

	public boolean DeletePizza(String codePizza) throws ExceptionMauvaisCode {
		EntityManager em=fact.createEntityManager();
		Query query =em.createQuery("select p from Pizza p where p.code=:codePizza", Pizza.class);
		query.setParameter("codePizza", codePizza);
		Pizza p = (Pizza) query.getResultList().get(0);
		EntityTransaction et = em.getTransaction();
		et.begin();
		if(p != null){
			em.remove(p);
		}
		et.commit();
		em.close();
		return false;
	}
	
}
