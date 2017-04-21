package fr.pizzeria.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import fr.pizzeria.exception.ExceptionMauvaisCode;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao {


	private String dataDir;

	public PizzaDaoImplFichier(String dataDir) {
		super();
		this.dataDir = dataDir;
	}
	@Override
	public List<Pizza> findAllPizzas() {

		try {
			return Files.list(Paths.get(dataDir)).map(path -> {
				
				String code = path.toFile().getName().replaceAll(".txt","");
				
				try {
					String[] valueTab = Files.lines(path)
												.findFirst()
												.orElseThrow(() -> new StockageException("fichier vide"))
												.split(";");
					
					return new Pizza(code, valueTab[0], Double.valueOf(valueTab[1]),  CategoriePizza.valueOf(valueTab[2]));
					
				} catch (IOException e) {
					throw new StockageException(e);
				}
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new StockageException(e);
		}
	}
	

	@Override
	public boolean SaveNewPizza(Pizza pizza) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pizza.getCode()+".txt")));
			// normalement si le fichier n'existe pas, il est crée à la racine du projet
			writer.write(pizza.getNom()+";"+pizza.getPrix()+";"+pizza.getCategorie());
			 
			writer.close();
			}
			catch (IOException e)
			{
			e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean UpdatePizza(String codePizza, Pizza pizza) throws ExceptionMauvaisCode {
		DeletePizza(codePizza);
		SaveNewPizza(pizza);
		return false;
	}

	@Override
	public boolean DeletePizza(String codePizza) throws ExceptionMauvaisCode {
		File fichier = new File(dataDir+"/"+codePizza+".txt");
		fichier.delete();
		return false;
	}

}
