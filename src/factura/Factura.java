package factura;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import cliente.Cliente;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFactura;
	@ManyToOne
	private Cliente idCliente;
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Factura(int idFactura, Cliente idCliente) {
		super();
		this.idFactura = idFactura;
		this.idCliente = idCliente;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	
}
