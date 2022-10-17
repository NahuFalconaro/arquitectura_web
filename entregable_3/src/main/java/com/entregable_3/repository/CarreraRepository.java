package com.entregable_3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>{

	@Query("SELECT NEW List(COUNT(c) as cantidad, c.nombre) "
			+ "FROM Carrera c "
			+ "JOIN EstudianteCarrera ec "
			+ "ON c.idCarrera = ec.idCarrera "
			+ "WHERE ec.graduado = false "
			+ "GROUP BY c.idCarrera")
	 List<Carrera> getAllWithStudentsOrderByCantInscriptos();
	 
	 
	 @Query("SELECT c "
				+ "FROM Carrera c "
				+ "WHERE c.nombre = :str ")
	 public Carrera getByName(String str);
	    
	}
