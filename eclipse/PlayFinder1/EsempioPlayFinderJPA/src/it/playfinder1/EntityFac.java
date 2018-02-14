package it.playfinder1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityFac {
	
	private static final String PERSISTENCE_UNIT_NAME = "PlayFinderJPA";

	private static EntityFac instance;
	
	private EntityManagerFactory emf;
	
	private EntityFac() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public static EntityFac getInstance() {
		if(instance == null)
			instance = new EntityFac();
		return instance;
	}
	
	public EntityManager getEm() {
		return emf.createEntityManager();
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


}
