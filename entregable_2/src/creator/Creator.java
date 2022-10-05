package creator;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import carrera.Carrera;
import carrera.CarreraRepositoryImpl;
import estudiante.Estudiante;
import estudiante.EstudianteRepositoryImpl;
import estudiante_carrera.EstudianteCarrera;
import estudiante_carrera.EstudianteCarreraRepositoryImpl;


public class Creator {

	private static SingletonEM em = SingletonEM.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstudianteRepositoryImpl e = new EstudianteRepositoryImpl();
		CarreraRepositoryImpl  c = new CarreraRepositoryImpl();
		EstudianteCarreraRepositoryImpl ec = new EstudianteCarreraRepositoryImpl();
		
		em.getEm();
		
		e.insertFromCsv();
		c.insertFromCsv();
		ec.insertFromCsv();
		
	//2
			//a
			System.out.println("A)");
			Carrera c1 = new Carrera("React de 0 a HEROE");
			System.out.println(c.saveCarrera(c1));
			Estudiante e1 = new Estudiante("juanpe","armella",23,"masculino", "4186548", "manuelita city", 1234);
			System.out.println(e.saveEstudiante(e1));  
			//b
			System.out.println("B)");
			EstudianteCarrera ec1 = new EstudianteCarrera(c.getByName(c1.getNombre()),e.getByLibreta(e1.getNro_libreta()),true,5,2017);
			System.out.println(ec.saveEstudianteCarrera(ec1));
			//c
			System.out.println("C)");
			System.out.println(e.getOrdenadoByCriterio("nombre"));
			//d
			System.out.println("D)");
			System.out.println(e.getByLibreta(e1.getNro_libreta()));
			//e
			System.out.println("E)");
			System.out.println(e.getAllByGenero("masculino"));
			//f
			System.out.println("F)");
			System.out.println(c.getAllWithStudentsOrderByCantInscriptos());
			//g
			System.out.println("G)");
			System.out.println(e.getAllByCarreraYCiudad(c.getByName(c1.getNombre()), "manuelita city"));
		
	//3
			System.out.println("Punto 3)");
			System.out.println(ec.getReport());
		
		em.closeConnection();
		
	}
	
	
	
	
}
