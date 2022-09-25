package factura;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import cliente.Clientes;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idFactura;
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Clientes idcliente;
	public Factura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Factura(int idFactura, Clientes idCliente) {
		super();
		this.idFactura = idFactura;
		this.idcliente = idCliente;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}
	public Clientes getIdCliente() {
		return idcliente;
	}
	public void setIdCliente(Clientes idCliente) {
		this.idcliente = idCliente;
	}
	
}
