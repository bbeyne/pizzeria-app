package fr.pizzeria.dao.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class Jdbcversion implements IPizzaDao{

static{
	try {
		Class.forName(ResourceBundle.getBundle("jdbc").getString("nameDriver"));
	} catch (ClassNotFoundException e) {
		throw new RuntimeException(e);
	}
}
	public List<Pizza> findAllPizzas() {
		try {
			Connection myConnection = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("adresse"), ResourceBundle.getBundle("jdbc").getString("login"),"");
			Statement statement = myConnection.createStatement();
			PreparedStatement selectPizzaSt = (PreparedStatement) myConnection.prepareStatement("SELECT * FROM pizzas WHERE ID=?");
			ResultSet listepizza =statement.executeQuery("SELECT * FROM pizzas");
			
			List<Pizza> pizzas = new ArrayList<Pizza>();
				while(listepizza.next()) {
					pizzas.add(new Pizza(listepizza.getString("code"), listepizza.getString("libelle"), listepizza.getDouble("prix"), CategoriePizza.valueOf(listepizza.getString("categorie"))));
				}
			listepizza.close();
			selectPizzaSt.close();
			statement.close();
			myConnection.close();
			return pizzas;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean SaveNewPizza(Pizza pizza) {
		try {
			Connection myConnection = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("adresse"), ResourceBundle.getBundle("jdbc").getString("login"),"");
			Statement statement = myConnection.createStatement();
			//String request="INSERT INTO pizzas(libelle,code,prix) VALUES('"+pizza.getNom()+"','"+pizza.getCode()+"',"+pizza.getPrix()+")";
			//int nbPizzaInsere = statement.executeUpdate("INSERT INTO pizzas(libelle,code,prix) VALUES(?,?,?)");
			PreparedStatement updatePizzaSt = (PreparedStatement) myConnection.prepareStatement("INSERT pizzas SET	libelle=?, code=?, prix=?, categorie=?");
					updatePizzaSt.setString(4, pizza.getCategorie().toString());
					updatePizzaSt.setDouble(3,pizza.getPrix());
					updatePizzaSt.setString(2, pizza.getCode());
					updatePizzaSt.setString(1, pizza.getNom());

					updatePizzaSt.executeUpdate();
			
			statement.close();
			myConnection.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdatePizza(String codePizza, Pizza pizza) throws ExceptionMauvaisCode {
		try {
			Connection myConnection = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("adresse"), ResourceBundle.getBundle("jdbc").getString("login"),"");
			PreparedStatement updatePizzaSt = (PreparedStatement) myConnection.prepareStatement("UPDATE pizzas SET	libelle=?, code=?, prix=?, categorie=? WHERE code=?");
			updatePizzaSt.setString(5, codePizza);
			updatePizzaSt.setString(4, pizza.getCategorie().toString());
			updatePizzaSt.setDouble(3,pizza.getPrix());
			updatePizzaSt.setString(2, pizza.getCode());
			updatePizzaSt.setString(1, pizza.getNom());

			updatePizzaSt.executeUpdate();
			myConnection.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeletePizza(String codePizza) throws ExceptionMauvaisCode {
		try {
			Connection myConnection = DriverManager.getConnection(ResourceBundle.getBundle("jdbc").getString("adresse"), ResourceBundle.getBundle("jdbc").getString("login"),"");
			PreparedStatement updatePizzaSt = (PreparedStatement) myConnection.prepareStatement("DELETE FROM pizzas WHERE code=?");

			updatePizzaSt.setString(1,codePizza);

			updatePizzaSt.executeUpdate();
			myConnection.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
