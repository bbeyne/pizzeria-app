package fr.pizzeria.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class TestJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");


		Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false", "root", "");


		Statement statement = myConnection.createStatement();


		ResultSet resultat = statement.executeQuery("SELECT * FROM client");
		while(resultat.next()) {

			Integer id = resultat.getInt("ID");

			String name = resultat.getString("nom");

			String price = resultat.getString("prenom");

			System.out.println("[id=" + id + " nom=" + name + " prenom=" + price + "]");
		}
		resultat.close();
		PreparedStatement selectClientSt = (PreparedStatement) myConnection.prepareStatement("SELECT * FROM client WHERE ID=?");
		ResultSet listeclient =statement.executeQuery("SELECT COUNT(id) FROM client");
		int nbclient=0;
		if (listeclient.next()){
			nbclient=listeclient.getInt(1);
		}
		
		for (int i = 1; i < nbclient+1; i++) {
			selectClientSt.setInt(1, i);
			ResultSet resultats = selectClientSt.executeQuery();
			while(resultats.next()) {

				Integer id = resultats.getInt("ID");

				String name = resultats.getString("nom");

				String price = resultats.getString("prenom");

				System.out.println("[id=" + id + " nom=" + name + " prenom=" + price + "]");
			}
		}
		
	}

}
