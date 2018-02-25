package it.playfinder1;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import it.playfinder.model.Amicizia;
import it.playfinder.model.User;

public class GestioneAccount {

	public EsitoOperazione login(String username, String password) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = EntityFac.getInstance().getEm();
		    User utente = em.find(User.class, username);
		    boolean ok = utente != null && utente.getPassword().equals(password);
			_return.setSuccess(ok);
			_return.setMessaggio(!ok ? "Accesso fallito" : "Accesso effettuato");
			if (ok)
				_return.setOggettoRisultante(utente);
			else
				_return.setOggettoRisultante(null);
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
		
	}

	public EsitoOperazione registrazione(String email, String username, String password, String nome, String cognome,
			String citta, int eta, String regione, String telefono) {
		EsitoOperazione _return = new EsitoOperazione();
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
		_return = registrazione(u);
		return _return;

	}
	
	public EsitoOperazione registrazione(User nuovoUtente) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			User u = em.find(User.class, nuovoUtente.getEmail());
			if(u != null) {
				_return.setSuccess(false);
				_return.setMessaggio("L'utente esiste già");
				_return.setOggettoRisultante(u);
			} else {				
				em.getTransaction().begin();
				em.persist(nuovoUtente);
				em.getTransaction().commit();
				
				_return.setSuccess(true);
				_return.setMessaggio("Utente creato con successo");
				_return.setOggettoRisultante(nuovoUtente);
			}
		} catch (Exception ex) {
			_return.setSuccess(false);
			_return.setMessaggio("Qualcosa è andato male => " + ex.getMessage());
			_return.setOggettoRisultante(ex);
		}
		return _return;
	}	
	
	public void aggiungiAmico(String usernameUtente, String usernameAmico) {
		EntityManager em = EntityFac.getInstance().getEm();
		User u = em.find(User.class, usernameUtente);
		User amico = em.find(User.class, usernameAmico);
		em.getTransaction().begin();
		if (u != null && amico != null) {
			u.addAmico(amico, false);		
		}
		em.getTransaction().commit();
	}
	public void accettaAmicizia(Amicizia amicizia) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.refresh(amicizia);
		em.getTransaction().begin();
		amicizia.setAccettata(true);
		em.getTransaction().commit();
	}
	
 	public User userPerUsername(String username) {
		User utente = null;
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			utente = em.createQuery("select u from User u where u.username=:username", User.class)
					.setParameter("username", username).getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return utente;
	}

	public void rimuoviAmicizia(Amicizia amicizia) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.refresh(amicizia);
		em.getTransaction().begin();
		amicizia.setAccettata(false);
		em.getTransaction().commit();

	}
	
}