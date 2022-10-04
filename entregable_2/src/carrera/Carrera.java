package carrera;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Carrera {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCarrera;
	@Column(name="nombre")
	private String nombre;
	public Carrera() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
	}
	public int getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(int idCarrera) {
		this.idCarrera = idCarrera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Carrera [idCarrera=" + idCarrera + ", nombre=" + nombre + "]";
	}

	
}
