package fr.pizzeria.Dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
				
				try(Stream<String> lines = Files.lines(path);){ //Cette notation permet de fermer le stream à la fin du bloc try et de liberer la ressource
			        
		            Optional<String> premiereLigneDuFichier=lines.findFirst();    //Recupère la première ligne du fichier, 
		                                                                            //on utilise un Optional pour eviter l'exception
		                                                                            //si le fichier est vide
		                                                                            
		        String premiereLigne=premiereLigneDuFichier.orElseThrow(()->new StockageException("fichier vide"));    //Permet de gèrer l'exception si le fichier est vide
		        
		        String[] valueTab=premiereLigne.split(";");   //Recupère les éléments de la ligne avec pour séparateur un ";"
		        
		        return new Pizza(code,valueTab[0],Double.valueOf(valueTab[1]),CategoriePizza.valueOf(valueTab[2])); //Retourne la pizza créer
		        
		        }catch(IOException e){
		            throw new StockageException(e);
		        }
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new StockageException(e);
		}
	}
    @Override
    public boolean SaveNewPizza(Pizza pizza){
    	
        String pathNewFile = DaoFichFactory.getDataDir()+"/" + pizza.getCode() + ".txt";
        try (BufferedWriter writer = Files.newBufferedWriter(FileSystems.getDefault().getPath(pathNewFile))) {
            String chaine = pizza.getNom() + ";" + pizza.getPrix() + ";" + pizza.getCategorie();
            writer.write(chaine, 0, chaine.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

//	@Override
//	public boolean SaveNewPizza(Pizza pizza) {
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pizza.getCode()+".txt")));
//			// normalement si le fichier n'existe pas, il est crée à la racine du projet
//			writer.write(pizza.getNom()+";"+pizza.getPrix()+";"+pizza.getCategorie());
//			 
//			writer.close();
//			}
//			catch (IOException e)
//			{
//			e.printStackTrace();
//			}
//		return false;
//	}

	@Override
	public boolean UpdatePizza(String codePizza, Pizza pizza) throws ExceptionMauvaisCode {
		this.DeletePizza(codePizza);
		this.SaveNewPizza(pizza);
		return false;
	}

	@Override
	public boolean DeletePizza(String codePizza) throws ExceptionMauvaisCode {
		try {
			Files.delete(Paths.get(dataDir+"/"+codePizza+".txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
