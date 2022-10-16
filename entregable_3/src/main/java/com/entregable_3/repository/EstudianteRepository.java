package com.entregable_3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entregable_3.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

    @Query("SELECT e "
			+ "FROM Estudiante e "
			+ "JOIN EstudianteCarrera ec "
			+ "ON (ec.idEstudiante = e.idEstudiante) "
			+ "WHERE (ec.idCarrera = :idCarrera)")
    public List<Estudiante> getAllByCarreraId(Long idCarrera);
    
    
    @Query("SELECT e "
			+ "FROM Estudiante e "
			+ "ORDER BY :columna ASC")
    public List<Estudiante> getOrdenadoByColumna(String columna);
}
