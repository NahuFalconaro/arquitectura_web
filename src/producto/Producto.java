package producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProducto;
	@Column(name="nombre")
	private String nombre;
	@Column(name="valor")
	private Float valor;
	
	public Producto(String nombre, Float valor) {
		super();
		this.nombre = nombre;
		this.valor = valor;
	}
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	
}
