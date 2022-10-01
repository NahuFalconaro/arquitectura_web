package creator;

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
		
//		em.getEm().getTransaction().begin();
//	
//		em.getEm().getTransaction().commit();
//		
//		em.closeConnection();
		
	}
	
	
}
