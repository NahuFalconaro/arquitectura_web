package com.entregable_3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;


public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

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
