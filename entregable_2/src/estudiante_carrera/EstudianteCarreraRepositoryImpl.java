package estudiante_carrera;

import java.util.List;

import carrera.Carrera;
import creator.SingletonEM;
import estudiante.Estudiante;

public class EstudianteCarreraRepositoryImpl implements EstudianteCarreraRepository {
	SingletonEM em =SingletonEM.getInstance();

	@Override
	public EstudianteCarrera saveEstudianteCarrera(Estudiante e, Carrera c, int antiguedad, boolean graduado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstudianteCarrera> getReport() {
		// TODO Auto-generated method stub
		return null;
	}

	 
	 
}