package entregable.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entregable.model.Carrera;
import entregable.model.Estudiante;
import entregable.model.EstudianteCarrera;
import entregable.repository.EstudianteRepository;

@Service
public class EstudianteService implements IEstudianteService{

	@Autowired
	private EstudianteRepository er;

	@Override
	public Estudiante saveEstudiante(Estudiante e) {
		er.save(e);
		return e;
	}

	@Override
	public List<Estudiante> getOrdenadoByColumna(String criterio) {
		return er.getOrdenadoByColumna(criterio);
	}

	@Override
	public Estudiante getByLibreta(int nro_libreta) {
		return er.getByLibreta(nro_libreta);
	}

	@Override
	public List<Estudiante> getAllByGenero(String genero) {
		return er.getAllByGenero(genero);
	}

	@Override
	public List<Estudiante> getAllByCarreraYCiudad(Long idCarrera, String ciudad) {
		return er.getAllByCarreraYCiudad(idCarrera, ciudad);
	}

	@Override
	public Estudiante getById(Long id) {
		return er.findById(id).orElse(null);
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
			e.printStackTrace();
		}
	}

	@Override
	public List<Estudiante> getAllByCarreraId(Long idCarrera) {
		return er.getAllByCarreraId(idCarrera);
	}

	
}
