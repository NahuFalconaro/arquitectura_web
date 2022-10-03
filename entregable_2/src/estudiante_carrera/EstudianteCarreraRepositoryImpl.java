package estudiante_carrera;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import carrera.Carrera;
import carrera.CarreraRepository;
import carrera.CarreraRepositoryImpl;
import creator.SingletonEM;
import estudiante.Estudiante;
import estudiante.EstudianteRepository;
import estudiante.EstudianteRepositoryImpl;


public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
	SingletonEM em = SingletonEM.getInstance();

	@Override
	public EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec) {
		em.getEm().getTransaction().begin();
		em.getEm().persist(ec);
		em.getEm().getTransaction().commit();
		return ec;
	}

	@Override
	public List<EstudianteCarrera> getReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFromCsv() {
		CSVParser parser;
		try {
			Reader in = new FileReader("estudiante_carrera.csv");
			parser = CSVFormat.DEFAULT.withHeader().parse(in);
			for (CSVRecord row : parser) {
				
				EstudianteRepositoryImpl er = new EstudianteRepositoryImpl();
				Estudiante e1 = er.getById(Integer.parseInt(row.get("idProducto")));
				
				CarreraRepositoryImpl cr = new CarreraRepositoryImpl();
				Carrera c1 = cr.getById(Integer.parseInt(row.get("idFactura")));
				
				EstudianteCarrera ec = new EstudianteCarrera(c1, e1,
						Boolean.parseBoolean(row.get("graduado")), Integer.parseInt(row.get("antiguedad")),
						Integer.parseInt(row.get("añoInicio")));
				this.saveEstudianteCarrera(ec);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}