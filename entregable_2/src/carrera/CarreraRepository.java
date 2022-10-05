package carrera;

import java.util.List;

import estudiante.Estudiante;

public interface CarreraRepository {

	 Carrera saveCarrera(Carrera c);
	 List<Carrera> getAllWithStudentsOrderByCantInscriptos();
	 void insertFromCsv();
	 Carrera getById(int id);
	 Carrera getByName(String str);
	}
