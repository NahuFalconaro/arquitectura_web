package creator;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import carrera.CarreraRepositoryImpl;
import estudiante.EstudianteRepositoryImpl;
import estudiante_carrera.EstudianteCarreraRepositoryImpl;


public class Creator {

	private static SingletonEM em = SingletonEM.getInstance();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstudianteRepositoryImpl e = new EstudianteRepositoryImpl();
		CarreraRepositoryImpl  c = new CarreraRepositoryImpl();
		EstudianteCarreraRepositoryImpl ec = new EstudianteCarreraRepositoryImpl();
		
		em.getEm();
		
//		e.insertFromCsv();
//		c.insertFromCsv();
//		ec.insertFromCsv();
		//2
		//a
		//b
		//c
		//d
		//e
		//f
		//g
		
		//3
		ec.getReport();
		
		em.closeConnection();
		
	}
	
	
	
	
}
