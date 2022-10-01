package factura;

import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;

import cliente.ClientDao;
import cliente.Clientes;
import creator.Dao;
import creator.SingletonEM;

public class FacturaDao implements Dao<Factura>{
	
	SingletonEM em =SingletonEM.getInstance();
	
	public Factura get(int id) {
		// TODO Auto-generated method stub
		Factura f = em.getEm().find(Factura.class, id);
		return f;
	}

	@Override
	public List<Factura> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Factura t) {
		em.getEm().persist(t);
	}

	@Override
	public void update(Factura t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Factura t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveParseFromRow(CSVRecord csv) {
		// TODO Auto-generated method stub
		ClientDao c = new ClientDao();
//		System.out.println(c.get(3));
		Clientes c1 = c.get(Integer.parseInt(csv.get("idCliente")));
		System.out.println(c1);
		Factura f1 = new Factura(Integer.parseInt(csv.get("idFactura")), c1);
		this.save(f1);
	}

	@Override
	public Factura getOneByQuery(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Factura> getAllByQuery(String q) {
		// TODO Auto-generated method stub
		return null;
	}

}
