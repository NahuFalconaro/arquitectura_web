package creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEM {
	
	private static SingletonEM instance = null;
	public EntityManager em;
	private EntityManagerFactory emf;
	private SingletonEM() {
		this.emf = Persistence.createEntityManagerFactory("entregable_1");
		this.em = emf.createEntityManager();
	}
	public static SingletonEM getInstance() {
		if(instance == null)
			instance = new SingletonEM();
		
		return instance;
	}
	public EntityManager getEm() {
		return em;
	}
	public void closeConnection() {
		em.close();
		emf.close();
	}
	public void clearCache() {
		this.em.flush();
		this.em.clear();
	}
	
}
