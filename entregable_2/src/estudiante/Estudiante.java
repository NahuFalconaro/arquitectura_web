package estudiante;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import carrera.Carrera;


@Entity
public class Estudiante {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEstudiante;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="edad")
	private int edad;
	@Column(name="genero")
	private String genero;
	@Column(name="dni")
	private String dni;
	@Column(name="ciudad")
	private String ciudad;
	@Column(name="nro_libreta")
	private int nro_libreta;

	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Estudiante(String nombre, String apellido, int nro_libreta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_libreta = nro_libreta;
		// TODO Auto-generated constructor stub
	}
	public Estudiante(String nombre, String apellido, int edad, String genero, String dni,
			String ciudad, int nro_libreta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudad = ciudad;
		this.nro_libreta = nro_libreta;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public int getNro_libreta() {
		return nro_libreta;
	}
	public void setNro_libreta(int nro_libreta) {
		this.nro_libreta = nro_libreta;
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", nro_libreta=" + nro_libreta + "]";
	}

	
	
	
	


	
	
	
}
