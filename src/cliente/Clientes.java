package cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idcliente;
	@Column(name="name")
	private String nombre;
	@Column(name="email")
	private String email;
	
	
	public Clientes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Clientes(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}

	public int getIdCliente() {
		return idcliente;
	}
	public void setIdCliente(int idCliente) {
		this.idcliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idcliente + ", nombre=" + nombre + ", email=" + email + "]";
	} 

}
