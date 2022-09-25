package producto;

import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;

import cliente.ClientDao;
import cliente.Clientes;
import creator.Dao;
import creator.SingletonEM;


public class ProductoDao implements Dao<Producto>{
	
	SingletonEM em =SingletonEM.getInstance();

	public Producto get(int id) {
		// TODO Auto-generated method stub
		Producto f = em.getEm().find(Producto.class, id);
		return f;
	}

	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Producto t) {
		em.getEm().persist(t);
	}

	@Override
	public void update(Producto t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Producto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveParseFromRow(CSVRecord csv) {
		Producto f1 = new Producto(csv.get("nombre"), Float.parseFloat(csv.get("valor")));
		this.save(f1);
	}

}
