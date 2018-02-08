package it.playfinder1;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import it.playfinder.model.Modulo;

public class GestioneModulo {

	public Modulo selezionaModulo(String Nome, EntityManager em) {
		
			Modulo modulo = null;
			try {
				modulo = em.createQuery("select u from Modulo u where u.Nome=:Nome", Modulo.class)
						.setParameter("nome", Nome).getSingleResult();
			} catch (NoResultException ex) {
				ex.printStackTrace();
			}
			return modulo;
		}
}
