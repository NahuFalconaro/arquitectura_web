package entregable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import entregable.service.CarreraService;
import entregable.service.EstudianteCarreraService;
import entregable.service.EstudianteService;

@SpringBootApplication
public class Entregable3Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Entregable3Application.class, args);
//		applicationContext.getBean(EstudianteService.class).insertFromCsv();
//		applicationContext.getBean(CarreraService.class).insertFromCsv();
//		applicationContext.getBean(EstudianteCarreraService.class).insertFromCsv();
	}
}
