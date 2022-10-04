package estudiante;

import java.util.List;

import carrera.Carrera;

public interface EstudianteRepository {

	 Estudiante saveEstudiante(Estudiante e);
	 List<Estudiante> getOrdenadoByCriterio(String criterio);
	 Estudiante getByLibreta(int nro_libreta);
	 List<Estudiante> getAllByGenero(String genero);
	 List<Estudiante> getAllByCarreraYCiudad(Carrera c,String ciudad);
	 Estudiante getById(int id);
	 void insertFromCsv();
	 List<Estudiante> getAllByCarreraId(int idCarrera);
	 List<Estudiante> getAllByAnioGraduacion();
	 List<Estudiante> getAllByAnioInscripcion();
	}
