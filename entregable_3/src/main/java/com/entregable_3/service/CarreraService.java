package com.entregable_3.service;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entregable_3.model.Carrera;
import com.entregable_3.repository.CarreraRepository;
import com.entregable_3.repository.EstudianteRepository;

@Service
public class CarreraService implements ICarreraService{
	
	
	@Autowired
	private CarreraRepository cr;
	
	@Override
	public Carrera saveCarrera(Carrera c) {
		cr.save(c);
		return c;
	}

	@Override
	public List<Carrera> getAllWithStudentsOrderByCantInscriptos() {
		return cr.getAllWithStudentsOrderByCantInscriptos();
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
		return cr.findById(id).orElse(null);
	}

	@Override
	public Carrera getByName(String str) {
		return cr.getByName(str);
	}

}
