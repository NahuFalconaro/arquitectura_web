package estudiante_carrera;

import java.util.List;

import carrera.Carrera;
import estudiante.Estudiante;

public interface EstudianteCarreraRepository {

	 EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec);
	 List<EstudianteCarrera> getReport();
	 void insertFromCsv();
	}
