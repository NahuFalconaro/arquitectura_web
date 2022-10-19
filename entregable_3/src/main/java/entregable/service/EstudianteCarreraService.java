package entregable.service;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entregable.model.Carrera;
import entregable.model.Estudiante;
import entregable.model.EstudianteCarrera;
import entregable.model.EstudianteCarreraDTO;
import entregable.repository.EstudianteCarreraRepository;


@Service
public class EstudianteCarreraService implements IEstudianteCarreraService{
	
	@Autowired
	private EstudianteCarreraRepository estudenCareerRepository;
	
	@Autowired
	private EstudianteService es;
	
	@Autowired
	private CarreraService cs;
	
	@Override
	public EstudianteCarrera saveEstudianteCarrera(EstudianteCarrera ec) {
		return estudenCareerRepository.save(ec);
	}

	@Override
	public TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> getReport() {
		HashMap<Integer, List<Estudiante>> cronologico;
		HashMap<Carrera, HashMap<Integer, List<Estudiante>>> reporte = new HashMap<Carrera, HashMap<Integer, List<Estudiante>>>();
		
		List<Carrera> carreras = estudenCareerRepository.findByIdCarrera();
		for (Carrera c : carreras) {

			cronologico = new HashMap<Integer, List<Estudiante>>();
			List<List<Object>> estudiantesByCarrera = estudenCareerRepository.findByIdEstudianteAndIdCarrera(c.getIdCarrera()); 
			List<EstudianteCarreraDTO> estudianteCarreraList = new ArrayList<EstudianteCarreraDTO>();
			for (List<Object> ec : estudiantesByCarrera) {
				EstudianteCarreraDTO ecDto = new EstudianteCarreraDTO(
					ec.get(0).toString(),
					ec.get(1).toString(),
					(int) ec.get(2),
					ec.get(3).toString(),
					(boolean) ec.get(4),
					(int) ec.get(5),
					(int)ec.get(6),
					((Carrera) ec.get(7)).getIdCarrera()
				);
				estudianteCarreraList.add(ecDto);
			}
			for (EstudianteCarreraDTO e : estudianteCarreraList) {
				Estudiante e1 = new Estudiante(e.getNombre(), e.getApellido(), e.getNroLibreta());
				List<Estudiante> retorno = new ArrayList<Estudiante>();
				
				if(!cronologico.containsKey(e.getAnioInicio())) {
					cronologico.put(e.getAnioInicio(), retorno);
				};
				cronologico.get(e.getAnioInicio()).add(e1);
				retorno = new ArrayList<Estudiante>();
				if(e.getAnioGraduacion() > 0) {
					if(!cronologico.containsKey(e.getAnioGraduacion())) {
						cronologico.put(e.getAnioGraduacion(), retorno);
					};
					cronologico.get(e.getAnioGraduacion()).add(e1);
				}
			}
			reporte.put(c, cronologico);
		}
		TreeMap<Carrera, HashMap<Integer, List<Estudiante>>> sorted = new TreeMap<>(reporte);
		return sorted;
	}

	@Override
	public void insertFromCsv() {
		CSVParser parser;
		try {
			Reader in = new FileReader("estudiante_carrera.csv");
			parser = CSVFormat.DEFAULT.withHeader().parse(in);
			for (CSVRecord row : parser) {
				
				Estudiante e1 = this.es.getById(Long.parseLong(row.get("idEstudiante")));
				
				Carrera c1 = this.cs.getById(Long.parseLong(row.get("idCarrera")));
				
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
