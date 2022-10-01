package creator;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
//
//		filereaderSave(productoDao, "productos.csv", em);
//		
//		filereaderSave(facturaProductoDao, "facturas-productos.csv", em);
		
		String q = "SELECT p "
				+ "FROM Producto p "
				+ "JOIN FacturaProducto fp "
				+ "ON (p.idProducto = fp.idProducto) "
				+ "GROUP BY p.idProducto "
				+ "ORDER BY SUM(cantidad * valor) DESC ";
		
			
		Producto st = productoDao.getOneByQuery(q);
		
		System.out.println(st);

		
		String q2 = "SELECT c "
				+ "	FROM Clientes c "
				+ "	JOIN Factura f "
				+ "		ON (c.idcliente = f.idcliente) "
				+ "	JOIN FacturaProducto fp"
				+ "		ON (fp.idFactura = f.idFactura) "
				+ "	JOIN Producto p "
				+ "		ON (fp.idProducto = p.idProducto) "
				+ "	GROUP BY c "
				+ "	ORDER BY SUM(p.valor * fp.cantidad) DESC ";
		
		List<Clientes> st2 = userDao.getAllByQuery(q2);
		
		System.out.println(st2);
			
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
