package entregable.repository;

import java.util.List;

import javax.persistence.Tuple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import entregable.model.CareerWithInscripts;
import entregable.model.Carrera;



@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Long>{

	@Query("SELECT  new entregable.model.CareerWithInscripts(c,COUNT(c) as cantidad) "
			+ "FROM Carrera c "
			+ "JOIN EstudianteCarrera ec "
			+ "ON c.idCarrera = ec.idCarrera "
			+ "WHERE ec.graduado = false "
			+ "GROUP BY c.idCarrera")
	 List<CareerWithInscripts> getAllWithStudentsOrderByCantInscriptos();
	 
	 
	 @Query("SELECT c "
				+ "FROM Carrera c "
				+ "WHERE c.nombre = :str ")
	 public Carrera getByName( String str);
	    
	}
