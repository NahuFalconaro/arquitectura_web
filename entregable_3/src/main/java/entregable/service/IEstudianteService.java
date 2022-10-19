package entregable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import entregable.model.Carrera;
import entregable.model.Estudiante;
import entregable.model.EstudianteCarrera;

@Service
public interface IEstudianteService {


	 Estudiante saveEstudiante(Estudiante e);
	 List<Estudiante> getOrdenadoByNombre();
	 List<Estudiante> getAllByGenero(String genero);
	 List<Estudiante> getAllByCarreraYCiudad(Long idCarrera, String ciudad);
	 Estudiante getByLibreta(int nro_libreta);
	 Estudiante getById(Long id);
	 void insertFromCsv();
	 List<Estudiante> getAllByCarreraId(Long idCarrera);
}
