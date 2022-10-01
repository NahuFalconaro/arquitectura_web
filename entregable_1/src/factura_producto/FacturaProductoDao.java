package factura_producto;

import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVRecord;


import creator.Dao;
import creator.SingletonEM;
import factura.Factura;
import factura.FacturaDao;
import producto.Producto;
import producto.ProductoDao;

public class FacturaProductoDao implements Dao<FacturaProducto>{
	
	SingletonEM em =SingletonEM.getInstance();

	@Override
	public Optional<FacturaProducto> get(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<FacturaProducto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(FacturaProducto t) {
		em.getEm().persist(t);

	}

	@Override
	public void update(FacturaProducto t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FacturaProducto t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveParseFromRow(CSVRecord csv) {
		// TODO Auto-generated method stub
		ProductoDao c = new ProductoDao();
		Producto p1 = c.get(Integer.parseInt(csv.get("idProducto")));
		FacturaDao f = new FacturaDao();
		Factura f1 = f.get(Integer.parseInt(csv.get("idFactura")));
		
		FacturaProducto fp = new FacturaProducto(f1,p1,Integer.parseInt(csv.get("cantidad")));
		this.save(fp);
	}

	@Override
	public FacturaProducto getOneByQuery(String q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FacturaProducto> getAllByQuery(String q) {
		// TODO Auto-generated method stub
		return null;
	}

}
