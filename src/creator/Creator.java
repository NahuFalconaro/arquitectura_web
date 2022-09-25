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
import factura_producto.FacturaProducto;
import factura_producto.FacturaProductoDao;
import producto.Producto;
import producto.ProductoDao;

public class Creator {
	private static Dao<Clientes> userDao;
	private static Dao<Factura> facturaDao;
	private static Dao<Producto> productoDao;
	private static Dao<FacturaProducto> facturaProductoDao;
	
	private static SingletonEM em = SingletonEM.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userDao = new ClientDao();
		facturaDao = new FacturaDao();
		productoDao = new ProductoDao();
		facturaProductoDao = new FacturaProductoDao();
		
		em.getEm().getTransaction().begin();

//		filereaderSave(userDao, "clientes.csv", em);
//
//		filereaderSave(facturaDao, "facturas.csv", em);

//		filereaderSave(productoDao, "productos.csv", em);
		
		filereaderSave(facturaProductoDao, "facturas-productos.csv", em);
		
		em.getEm().getTransaction().commit();
		
		em.closeConnection();
		
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
