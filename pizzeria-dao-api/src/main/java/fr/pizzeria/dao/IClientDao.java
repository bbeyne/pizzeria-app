package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.model.Client;

public interface IClientDao {

	List<Client> findAllClients();

	boolean SaveNewClient(Client client);

	boolean UpdateClient(String mail, Client client) throws ExceptionMauvaisCode;

	boolean DeleteClient(String mail) throws ExceptionMauvaisCode;

}
