package cliente;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import creator.Dao;
import creator.SingletonEM;

public class ClientDao implements Dao<Clientes>{
	
	SingletonEM em =SingletonEM.getInstance();

	//conexion a entityManager
	//en cada metodo hacemos, em.persist()?
	@Override
	public Clientes get(int id) {
		// TODO Auto-generated method stub
		Clientes c = em.getEm().find(Clientes.class, id);
		return c;
	}

	@Override
	public List<Clientes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Clientes t) {
		// TODO Auto-generated method stub
		System.out.println(t.toString());
		em.getEm().getTransaction().begin();
		em.getEm().persist(t);
		em.getEm().getTransaction().commit();

	}

	@Override
	public void update(Clientes t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Clientes t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void saveParseFromRow(CSVRecord csv) {
		Clientes c = new Clientes(csv.get("nombre"), csv.get("email"));
		this.save(c);
	}
}
