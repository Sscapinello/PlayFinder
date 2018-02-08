package it.playfinder1;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import it.playfinder.model.Amicizia;
import it.playfinder.model.User;

public class GestioneAccount {

	public boolean login(String mailOrUsername, String password) {
		EntityManager em = EntityFac.emf.createEntityManager();
		User utente = em.find(User.class, mailOrUsername);
		if (utente != null) {
			return checkPassword(password, utente);
		} else {
			utente = userPerUsername(mailOrUsername, em);
			if (utente != null) {
				return checkPassword(password, utente);
			}
		}
		return false;
	}

	public boolean registrazione(String email, String username, String password, String nome, String cognome,
			String citta, int eta, String regione, String telefono) {
		EntityManager em = EntityFac.emf.createEntityManager();
		User user = em.find(User.class, email);
		if (user != null) {
			return false;
		} else {
			user = userPerUsername(username, em);
			if (user != null) {
				return false;
			}
		}
		User u = new User();
		u.setCognome(cognome);
		u.setCitta(citta);
		u.setEmail(email);
		u.setEta(eta);
		u.setNome(nome);
		u.setPassword(password);
		u.setRegione(regione);
		u.setTelefono(telefono);
		u.setUsername(username);

		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

		return true;

	}
	
	public void aggiungiAmico(String usernameUtente, String usernameAmico) {
		EntityManager em = EntityFac.emf.createEntityManager();
		User u = em.find(User.class, usernameUtente);
		User amico = em.find(User.class, usernameAmico);
		em.getTransaction().begin();
		if (u != null && amico != null) {
			u.addAmico(amico, false);		
		}
		em.getTransaction().commit();
	}
	public void accettaAmicizia(Amicizia amicizia) {
		EntityManager em = EntityFac.emf.createEntityManager();
		em.refresh(amicizia);
		em.getTransaction().begin();
		amicizia.setAccettata(true);
		em.getTransaction().commit();
	}
	
 	private User userPerUsername(String username, EntityManager em) {
		User utente = null;
		try {
			utente = em.createQuery("select u from User u where u.username=:username", User.class)
					.setParameter("username", username).getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return utente;
	}

	private boolean checkPassword(String password, User user) {
		if (user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	public void rimuoviAmicizia(Amicizia amicizia) {
		EntityManager em = EntityFac.emf.createEntityManager();
		em.refresh(amicizia);
		em.getTransaction().begin();
		amicizia.setAccettata(false);
		em.getTransaction().commit();

	}
	
}