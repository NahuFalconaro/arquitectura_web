package entregable.service;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import entregable.model.Carrera;
import entregable.model.Estudiante;
import entregable.model.EstudianteCarrera;


@Service
public interface IEstudianteCarreraService {
	
	 EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec);
	 TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport();
	 void insertFromCsv();
}
