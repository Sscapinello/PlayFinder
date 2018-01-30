package it.playfinder1;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityFac {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PlayFinderJPA");

	public static void main(String[] args) {
		
	}

}
