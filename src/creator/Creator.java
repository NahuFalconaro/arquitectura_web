package creator;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import cliente.ClientDao;
import cliente.Clientes;
import factura.Factura;
import factura.FacturaDao;

public class Creator {
	private static Dao<Clientes> userDao;
	private static Dao<Factura> facturaDao;
	
	private static SingletonEM em =SingletonEM.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userDao = new ClientDao();
//		facturaDao = new FacturaDao();
		em.getEm().getTransaction().begin();
		em.clearCache();
		em.getEm().getTransaction().commit();
		filereaderSave(userDao, "clientes.csv", em);
		em.closeConnection();
//		em.getEm().getTransaction().begin();
//		filereaderSave(facturaDao, "facturas.csv", em);
//		em.getEm().getTransaction().commit();

//		em.getEm().getTransaction().begin();
//		filereaderSave(userDao, "productos.csv", em);
//		em.getEm().getTransaction().commit();
//		
//
//		em.getEm().getTransaction().begin();
//		filereaderSave(userDao, "facturas-productos.csv", em);
//		em.getEm().getTransaction().commit();
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> void filereaderSave(Dao<T> d, String file, SingletonEM em) {
		CSVParser parser;
		try {
			Reader in = new FileReader(file); 
			parser = CSVFormat.DEFAULT.withHeader().parse(in);
			for(CSVRecord row: parser) {
				d.saveParseFromRow(row);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
