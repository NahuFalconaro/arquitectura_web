package estudiante;

import java.util.List;

import carrera.Carrera;
import creator.SingletonEM;

public class EstudianteRepositoryImpl implements EstudianteRepository {
	SingletonEM em =SingletonEM.getInstance();

	@Override
	public Estudiante saveEstudiante(Estudiante e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> getOrdenadoByDni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estudiante getByLibreta(int nro_libreta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> getAllByGenero(String genero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estudiante> getAllByCarrera(Carrera c) {
		// TODO Auto-generated method stub
		return null;
	}




	 
	 
}