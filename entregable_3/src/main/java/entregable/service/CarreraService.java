package entregable.service;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entregable.model.Carrera;
import entregable.repository.CarreraRepository;


@Service
public class CarreraService implements ICarreraService{
	
	
	@Autowired
	private CarreraRepository careerRepository;
	
	@Override
	public Carrera saveCarrera(Carrera c) {
		careerRepository.save(c);
		return c;
	}

	@Override
	public List<Carrera> getAllWithStudentsOrderByCantInscriptos() {
		return careerRepository.getAllWithStudentsOrderByCantInscriptos();
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
	public Carrera getById(Long id) {
		return careerRepository.findById(id).orElse(null);
	}

	@Override
	public Carrera getByName(String str) {
		return careerRepository.getByName(str);
	}

}
