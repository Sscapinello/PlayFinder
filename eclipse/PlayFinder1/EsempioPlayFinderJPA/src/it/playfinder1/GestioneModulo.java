package it.playfinder1;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import it.playfinder.model.Modulo;

public class GestioneModulo {

	public Modulo selezionaModulo(String nome) {
		EntityManager em = EntityFac.getInstance().getEm();
			Modulo modulo = null;
			try {
				modulo = em.createQuery("select u from Modulo u where u.nome=:nome", Modulo.class)
						.setParameter("nome", nome).getSingleResult();
			} catch (NoResultException ex) {
				ex.printStackTrace();
			}
			return modulo;
		}
	
}
