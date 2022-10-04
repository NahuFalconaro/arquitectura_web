package DTOEstudianteCarrera;

import carrera.Carrera;

public class EstudianteCarreraDTO {
	
	private String nombre;
	private String apellido;
	private String nombreCarrera;
	private int nro_libreta;
	private Boolean isGraduado;
	private Integer anioInicio;
	private Integer anioGraduacion;
	private Carrera idCarrera;
	
	public EstudianteCarreraDTO(String nombre, String apellido, int nro_libreta, String nombreCarrera, Boolean isGraduado, Integer anioInicio,
			Integer anioGraduacion, Carrera idCarrera) {
		super();
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.nro_libreta = nro_libreta;
		this.nombreCarrera = nombreCarrera;
		this.isGraduado = isGraduado;
		this.anioInicio = anioInicio;
		this.anioGraduacion = anioGraduacion;
		this.idCarrera = idCarrera;
	}

	public String getNombreApellido() {
		return this.getNombre() + this.getApellido();
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

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public Boolean getIsGraduado() {
		return isGraduado;
	}

	public void setIsGraduado(Boolean isGraduado) {
		this.isGraduado = isGraduado;
	}

	public Integer getAnioInicio() {
		return anioInicio;
	}

	public void setAnioInicio(int anioInicio) {
		this.anioInicio = anioInicio;
	}

	public Integer getAnioGraduacion() {
		return anioGraduacion;
	}
	public void setNroLibreta(int nro_libreta) {
		this.nro_libreta = nro_libreta;
	}

	public Integer getNroLibreta() {
		return nro_libreta;
	}
	public void setAnioGraduacion(int anioGraduacion) {
		this.anioGraduacion = anioGraduacion;
	}

	public Carrera getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Carrera idCarrera) {
		this.idCarrera = idCarrera;
	}

	@Override
	public String toString() {
		return "EstudianteCarreraDTO [nombre=" + nombre + ", apellido=" + apellido + ", nro_libreta=" + nro_libreta
				+ "]";
	}

	public EstudianteCarreraDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
