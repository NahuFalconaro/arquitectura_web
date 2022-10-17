package com.entregable_3.repository;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entregable_3.model.Carrera;
import com.entregable_3.model.Estudiante;
import com.entregable_3.model.EstudianteCarrera;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Long>{
    @Query("SELECT c "
			+ "FROM Carrera c "
			+ "JOIN EstudianteCarrera ec "
			+ "ON (c.idCarrera = ec.idCarrera) "
			+ "GROUP BY c.idCarrera")
    public List<Carrera> getAllGroupByCarrera();
    
    @Query("SELECT NEW List( e.nombre, e.apellido,e.nro_libreta,"
			+ "c.nombre, ec.graduado, ec.añoInicio, ec.añoGraduacion, ec.idCarrera ) "
			+ "FROM EstudianteCarrera ec "
			+ "JOIN Estudiante e ON ec.idEstudiante = e.idEstudiante "
			+ "JOIN Carrera c ON ec.idCarrera = c.idCarrera "
			+ "WHERE ec.idCarrera =:idCarrera")
    public List<List<Object>> getEstudiantesByCarreraId(Long idCarrera);
}
