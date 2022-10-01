package estudiante_carrera;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import carrera.Carrera;
import estudiante.Estudiante;


@Entity
public class EstudianteCarrera implements Serializable {
	@Id
	@ManyToOne
	private Carrera idCarrera;
	@Id
	@ManyToOne
	private Estudiante idEstudiante;
	@Column(name="graduado")
	private boolean graduado;
	@Column(name="antiguedad")
	private int antiguedad;
	@Column(name="añoInicio")
	private int añoInicio;
	
	public EstudianteCarrera() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EstudianteCarrera(Carrera idCarrera, Estudiante idEstudiante, boolean graduado, int antiguedad,int añoInicio) {
		super();
		this.idCarrera = idCarrera;
		this.idEstudiante = idEstudiante;
		this.graduado = graduado;
		this.antiguedad = antiguedad;
		this.añoInicio = añoInicio;
	}
	public Carrera getIdCarrera() {
		return idCarrera;
	}
	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}
	public Estudiante getIdEstudiante() {
		return idEstudiante;
	}
	public void setIdEstudiante(Estudiante idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	public boolean isGraduado() {
		return graduado;
	}
	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	@Override
	public String toString() {
		return "EstudianteCarrera [idCarrera=" + idCarrera + ", idEstudiante=" + idEstudiante + ", graduado=" + graduado
				+ ", antiguedad=" + antiguedad + "]";
	}
	public int getAñoInicio() {
		return añoInicio;
	}
	public void setAñoInicio(int añoInicio) {
		this.añoInicio = añoInicio;
	}
	
	


	
}
