package entregable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import entregable.model.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

    @Query("SELECT e "
			+ "FROM Estudiante e "
			+ "JOIN EstudianteCarrera ec "
			+ "ON (ec.idEstudiante = e.idEstudiante) "
			+ "WHERE (ec.idCarrera = :idCarrera)")
    public List<Estudiante> getAllByCarreraId(Long idCarrera);
    
    
    @Query("SELECT e "
			+ "FROM Estudiante e "
			+ "ORDER BY nombre ASC")
    public List<Estudiante> getOrdenadoByNombre();
    
    @Query("SELECT e "
			+ "FROM Estudiante e "
			+ "WHERE (e.nro_libreta = :nro_libreta)")
    public Estudiante getByLibreta(int nro_libreta);
    
    @Query("SELECT e "
			+ "FROM Estudiante e "
			+ "WHERE (e.genero = :genero)")
    public List<Estudiante> getAllByGenero(String genero);
    
    @Query(value = "SELECT * "
			+ "FROM Estudiante e "
			+ "JOIN EstudianteCarrera ec "
			+ "ON (ec.idCarrera = :idCarrera) "
			+ "WHERE (e.ciudad = :city)", nativeQuery = true)
     public List<Estudiante> getAllByCarreraYCiudad(Long idCarrera, String city);
    
}
