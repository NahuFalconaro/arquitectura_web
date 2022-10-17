package com.entregable_3.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;
import com.entregable_3.model.EstudianteCarrera;

public interface IEstudianteCarreraService {
	

	 EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec);
	 TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport();
	 void insertFromCsv();
}
