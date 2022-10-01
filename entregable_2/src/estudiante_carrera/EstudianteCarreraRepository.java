package estudiante_carrera;

import java.util.List;

import carrera.Carrera;
import estudiante.Estudiante;

public interface EstudianteCarreraRepository {

	 EstudianteCarrera saveEstudianteCarrera(Estudiante e,Carrera c,int antiguedad,boolean graduado);
	 List<EstudianteCarrera> getReport();
	}
