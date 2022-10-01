package carrera;

import java.util.List;

public interface CarreraRepository {

	 Carrera saveCarrera(Carrera c);
	 List<Carrera> getAllWithStudents();
	}
