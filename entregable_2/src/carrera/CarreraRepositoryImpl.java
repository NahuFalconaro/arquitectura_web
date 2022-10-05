package carrera;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import creator.SingletonEM;
import estudiante.Estudiante;

public class CarreraRepositoryImpl implements CarreraRepository {
	SingletonEM em =SingletonEM.getInstance();

	@Override
	public Carrera saveCarrera(Carrera c) {
		em.getEm().getTransaction().begin();
		em.getEm().persist(c);
		em.getEm().getTransaction().commit();
		return c;
	}

	@Override
	public List<Carrera> getAllWithStudentsOrderByCantInscriptos() {
		String q = "SELECT NEW List(COUNT(c) as cantidad, c.nombre) "
				+ "FROM Carrera c "
				+ "JOIN EstudianteCarrera ec "
				+ "ON c.idCarrera = ec.idCarrera "
				+ "WHERE ec.graduado = false "
				+ "GROUP BY c.idCarrera";
		
		List<Carrera> C = em.getEm().createQuery(q).getResultList();
		
		return C;
	}

	@Override
	public void insertFromCsv() {
		CSVParser parser;
		try {
			Reader in = new FileReader("carreras.csv");
			parser = CSVFormat.DEFAULT.withHeader().parse(in);
			for (CSVRecord row : parser) {
				Carrera c = new Carrera(row.get("nombre"));
				this.saveCarrera(c);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Carrera getById(int id) {
		Carrera c = em.getEm().find(Carrera.class, id);
		return c;
	}

	@Override
	public Carrera getByName(String str) {
		String q = "SELECT c "
				+ "FROM Carrera c "
				+ "WHERE c.nombre = '"+str+"' ";
		Carrera C = (Carrera) em.getEm().createQuery(q).getSingleResult();
		
		return C;
	}

	 
	 
}