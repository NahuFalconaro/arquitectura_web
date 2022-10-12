package com.entregable_3.repository;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;
import com.entregable_3.model.EstudianteCarrera;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long>{

	 EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec);
	 TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport();
	 void insertFromCsv();
	}
