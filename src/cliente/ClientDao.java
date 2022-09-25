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

public class ClientDao implements Dao<Cliente>{
	
	SingletonEM em = SingletonEM.getInstance();

	//conexion a entityManager
	//en cada metodo hacemos, em.persist()?
	@Override
	public Optional<Cliente> get(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Cliente> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void save(Cliente t) {
		// TODO Auto-generated method stub
		CSVParser parser;
		try {
			
			
			parser = CSVFormat.DEFAULT.withHeader().parse(in);
			for(CSVRecord row: parser) {
				System.out.println(row.get("idCliente"));
				System.out.println(row.get("nombre"));
				System.out.println(row.get("email"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Cliente t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		
	}

}
