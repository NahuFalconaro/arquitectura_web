package carrera;

import java.util.List;

import estudiante.Estudiante;

public interface CarreraRepository {

	 Carrera saveCarrera(Carrera c);
	 List<Carrera> getAllWithStudents();
	 void insertFromCsv();
	 Carrera getById(int id);
	}
