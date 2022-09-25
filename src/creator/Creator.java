package creator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cliente.ClientDao;
import cliente.Cliente;

public class Creator {
	private static Dao<Cliente> userDao;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
//		userDao = new ClientDao();
//		userDao.save(null);
		Reader in = new FileReader("~/facultad/Arqui/Practica/entregable_1/src/cliente/clientes.csv");
		System.out.println(in);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
	}

}
