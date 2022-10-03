package estudiante;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import carrera.Carrera;
import creator.SingletonEM;

public class EstudianteRepositoryImpl implements EstudianteRepository {
	SingletonEM em = SingletonEM.getInstance();

	@Override
	public Estudiante saveEstudiante(Estudiante e) {
		em.getEm().getTransaction().begin();
		em.getEm().persist(e);
		em.getEm().getTransaction().commit();
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> getOrdenadoByCriterio(String criterio) {
		String q = "SELECT e "
				+ "FROM estudiante e "
				+ "ORDER BY " + criterio + " ASC";

		List<Estudiante> e = em.getEm().createQuery(q).getResultList();
		
		return e;
	}

	@Override
	public Estudiante getByLibreta(int nro_libreta) {
		String q = "SELECT e "
				+ "FROM estudiante e "
				+ "WHERE (e.nro_libreta = " + nro_libreta +")";

		Estudiante e = (Estudiante) em.getEm().createQuery(q).getSingleResult();
		
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> getAllByGenero(String genero) {
		String q = "SELECT e "
				+ "FROM estudiante e "
				+ "WHERE (e.genero = " + genero +")";

		List<Estudiante> e = em.getEm().createQuery(q).getResultList();
		
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estudiante> getAllByCarreraYCiudad(Carrera c,String ciudad) {
		String q = "SELECT e "
				+ "FROM estudiante e"
				+ "JOIN estudiante_carrera ec "
				+ "ON (ec.idCarrera = " + c.getIdCarrera() + ") "
				+ "WHERE (e.ciudad = " + ciudad + ") ";

		List<Estudiante> e = em.getEm().createQuery(q).getResultList();
		
		return e;
	}

	@Override
	public void insertFromCsv() {
		CSVParser parser;
		try {
			Reader in = new FileReader("estudiantes.csv");
			parser = CSVFormat.DEFAULT.withHeader().parse(in);
			for (CSVRecord row : parser) {
				Estudiante e = new Estudiante(row.get("nombre"), row.get("apellido"), Integer.parseInt(row.get("edad")),
						row.get("genero"), row.get("dni"), row.get("ciudad"), Integer.parseInt(row.get("nro_libreta")));
				this.saveEstudiante(e);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Estudiante getById(int id) {
		Estudiante e = em.getEm().find(Estudiante.class, id);
		return e;
	}
	
	

}