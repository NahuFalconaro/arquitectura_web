package com.entregable_3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entregable_3.model.Carrera;

public interface CarreraRepository extends JpaRepository<Carrera, Long>{

	 Carrera saveCarrera(Carrera c);
	 List<Carrera> getAllWithStudentsOrderByCantInscriptos();
	 void insertFromCsv();
	 Carrera getById(int id);
	 Carrera getByName(String str);
	}
