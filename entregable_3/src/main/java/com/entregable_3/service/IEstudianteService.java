package com.entregable_3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;

@Service
public interface IEstudianteService {


	 Estudiante saveEstudiante(Estudiante e);
	 List<Estudiante> getOrdenadoByColumna(String criterio);
	 List<Estudiante> getAllByGenero(String genero);
	 List<Estudiante> getAllByCarreraYCiudad(Long idCarrera, String ciudad);
	 Estudiante getByLibreta(int nro_libreta);
	 Estudiante getById(Long id);
	 void insertFromCsv();
	 List<Estudiante> getAllByCarreraId(Long idCarrera);
}
