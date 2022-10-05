package estudiante_carrera;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import carrera.Carrera;
import estudiante.Estudiante;

public interface EstudianteCarreraRepository {

	 EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec);
	 TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport();
	 void insertFromCsv();
	}
