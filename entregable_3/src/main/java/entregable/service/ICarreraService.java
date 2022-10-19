package entregable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import entregable.model.CareerWithInscripts;
import entregable.model.Carrera;
@Service
public interface ICarreraService {
	
	 Carrera saveCarrera(Carrera c);
	 List<CareerWithInscripts> getAllWithStudentsOrderByCantInscriptos();
	 void insertFromCsv();
	 Carrera getById(Long id);
	 Carrera getByName(String str);
}
