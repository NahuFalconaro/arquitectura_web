package com.entregable_3.service;

import java.util.List;

import com.entregable_3.model.Carrera;

public interface ICarreraService {
	
	 Carrera saveCarrera(Carrera c);
	 List<Carrera> getAllWithStudentsOrderByCantInscriptos();
	 void insertFromCsv();
	 Carrera getById(Long id);
	 Carrera getByName(String str);
}
