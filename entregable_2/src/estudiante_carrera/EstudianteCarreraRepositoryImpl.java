package estudiante_carrera;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import DTOEstudianteCarrera.EstudianteCarreraDTO;
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
	
	
	/*
	* Generar un reporte de las carreras, que para cada carrera incluya información de los
	inscriptos y egresados por año. Se deben ordenar las carreras alfabéticamente, 
		y presentar los años de manera cronológica.
	 * */
//	carrera1-anio 2010: 10 graduados 5 inscriptos
//			 anio 2015: 11 gradudos 10 inscriptos
//	carrera2-anio 2018: 10 graduados 5 inscriptos
	
	
	//getInscriptos, groupby by anoinicio
	//los metes al array
	//select e, (ec.antiguedad + ec.anioinicio) as aniograduacion
	//where graduado = true
	//los metes al array
/*
SELECT e.nombre,e.apellido, c.nombre, ec.graduado, ec.añoinicio, ec.añograduacion, ec.idcarrera_idcarrera
FROM public.estudiantecarrera ec
JOIN public.estudiante e ON ec.idestudiante_idestudiante = e.idestudiante
JOIN public.carrera c ON ec.idcarrera_idcarrera = c.idcarrera
WHERE ec.idcarrera_idcarrera = 3

 * */
	@Override
	public List<EstudianteCarrera> getReport() {
		HashMap<Integer, List<Estudiante>> cronologico;
		HashMap<Carrera, HashMap<Integer, List<Estudiante>>> reporte = new HashMap<Carrera, HashMap<Integer, List<Estudiante>>>();
		
		
		String carrerasIDQuery = "SELECT c "
								+ "FROM Carrera c "
								+ "JOIN EstudianteCarrera ec "
								+ "ON (c.idCarrera = ec.idCarrera) "
								+ "GROUP BY c.idCarrera";
		
		List<Carrera> carreras = (em.getEm().createQuery(carrerasIDQuery).getResultList());
		EstudianteRepositoryImpl er = new EstudianteRepositoryImpl();
		
		for (Carrera c : carreras) {

			cronologico = new HashMap<Integer, List<Estudiante>>();
			String estudiantesByCarreraQuery = "SELECT NEW List( e.nombre, e.apellido,e.nro_libreta,"
										+ "c.nombre, ec.graduado, ec.añoInicio, ec.añoGraduacion, ec.idCarrera ) "
										+ "FROM EstudianteCarrera ec "
										+ "JOIN Estudiante e ON ec.idEstudiante = e.idEstudiante "
										+ "JOIN Carrera c ON ec.idCarrera = c.idCarrera "
										+ "WHERE ec.idCarrera ="+c.getIdCarrera()+"";
			
			List<List<Object>> estudiantesByCarrera = em.getEm().createQuery(estudiantesByCarreraQuery).getResultList();
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
				List<Estudiante> retorno = new ArrayList<Estudiante>();
				Estudiante e1 = new Estudiante(e.getNombre(), e.getApellido(), e.getNroLibreta());
				
				if(!cronologico.containsKey(e.getAnioInicio())) {
					cronologico.put(e.getAnioInicio(), retorno);
				};
				cronologico.get(e.getAnioInicio()).add(e1);
				if(!cronologico.containsKey(e.getAnioGraduacion())) {
					cronologico.put(e.getAnioGraduacion(), retorno);
				};
				cronologico.get(e.getAnioGraduacion()).add(e1);
			}
			reporte.put(c, cronologico);
		}
		System.out.println(reporte);
		
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
				Estudiante e1 = er.getById(Integer.parseInt(row.get("idEstudiante")));
				
				CarreraRepositoryImpl cr = new CarreraRepositoryImpl();
				Carrera c1 = cr.getById(Integer.parseInt(row.get("idCarrera")));
				
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