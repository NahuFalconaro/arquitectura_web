package factura_producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import factura.Factura;
import producto.Producto;

@Entity
public class FacturaProducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRelation;
	@ManyToOne
	private Factura idFactura;
	@ManyToOne
	private Producto idProducto;
	@Column(name="cantidad")
	private int cantidad;
	
	public FacturaProducto(Factura idFactura, Producto idProducto, int cantidad) {
		super();
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public FacturaProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Factura getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(Factura idFactura) {
		this.idFactura = idFactura;
	}
	public Producto getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Producto idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
