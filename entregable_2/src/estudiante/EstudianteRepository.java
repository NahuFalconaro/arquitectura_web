package estudiante;

import java.util.List;

import carrera.Carrera;

public interface EstudianteRepository {

	 Estudiante saveEstudiante(Estudiante e);
	 List<Estudiante> getOrdenadoByDni();
	 Estudiante getByLibreta(int nro_libreta);
	 List<Estudiante> getAllByGenero(String genero);
	 List<Estudiante> getAllByCarrera(Carrera c);
	}
