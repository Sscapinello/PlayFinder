package it.playfinder1;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import it.playfinder.model.Amicizia;
import it.playfinder.model.Evento;
import it.playfinder.model.RuoloPartita;
import it.playfinder.model.Squadra;
import it.playfinder.model.User;
import it.playfinder.model.UserInEvento;
import it.playfinder1.GestioneEvento;;

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
		u.setProfilePicturePath("profileImage/pPicture.png");
		_return = registrazione(u);
		return _return;

	}

	public EsitoOperazione registrazione(User nuovoUtente) {
		EsitoOperazione _return = new EsitoOperazione();
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			User u = em.find(User.class, nuovoUtente.getEmail());
			if (u != null) {
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
		em.getTransaction().begin();
		User u = em.find(User.class, usernameUtente);
		User amico = em.find(User.class, usernameAmico);
		boolean bho = false;
		List<Amicizia> amici = u.getAmici();
		for (Amicizia a : amici) {
			String mbare = a.getUtente1().getUsername();
			if (mbare.equals(usernameAmico)) {
				bho = true;
			}
		}
		List<Amicizia> amicibis = u.getAmicoDi();
		for (Amicizia a : amicibis) {
			String mbare = a.getUtente2().getUsername();
			if (mbare.equals(usernameAmico)) {
				bho = true;
			}
		}
		List<Amicizia> amicitris = amico.getAmici();
		for (Amicizia a : amicitris) {
			String mbare = a.getUtente1().getUsername();
			if (mbare.equals(usernameUtente)) {
				bho = true;
			}
		}
		List<Amicizia> amiciQuatt = amico.getAmicoDi();
		for (Amicizia a : amiciQuatt) {
			String mbare = a.getUtente1().getUsername();
			if (mbare.equals(usernameUtente)) {
				bho = true;
			}
		}		
		if (u != null && amico != null && bho == false) {
			u.addAmico(amico, false);
		}
		em.getTransaction().commit();
		em.close();
	}

	public void accettaAmicizia(Amicizia amicizia) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		amicizia.setAccettata(true);
		em.merge(amicizia);
		em.getTransaction().commit();
		em.close();
	}

	public Amicizia amiciziaPerId(int idAmicizia) {
		EntityManager em = EntityFac.getInstance().getEm();
		Amicizia amicizia = em.find(Amicizia.class, idAmicizia);
		em.close();
		return amicizia;

	}

	public User userPerUsername(String username) {
		User utente = null;
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			utente = em.createQuery("select u from User u where u.username=:username", User.class)
					.setParameter("username", username).getSingleResult();
			em.close();

		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return utente;
	}

	public void rimuoviAmicizia(Amicizia amicizia) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		Amicizia amico = em.merge(amicizia);
		em.remove(amico);
		em.getTransaction().commit();
		em.close();
	}

	public List<Evento> storico(User u) {
		GestioneEvento ge = new GestioneEvento();
		UserInEvento ue = null;
		List<Evento> e = ge.elencoEventi();
		List<Evento> storico = new ArrayList();
		for (Evento evento : e) {
			if (evento.getEsito() != null && ge.partecipa(u.getUsername(), evento.getIdEvento()) != null) {
				storico.add(evento);
			}
		}

		return storico;

	}

	public int percentualeVittoria(String username) {
		int percentualeVittoria = 0;
		int vittorie = 0;
		int i = 0;
		User user = userPerUsername(username);
		List<RuoloPartita> ruoliPartita = user.getRuoliPartite();
		for (RuoloPartita ruolo : ruoliPartita) {
			Squadra squadra = ruolo.getSquadra();
			Evento eventoCasa = squadra.getEventoCasa();
			Evento eventoTrasferta = squadra.getEventoTrasferta();
			if (eventoCasa != null) {
				if(eventoCasa.getTerminato() == true) {
					i++;
				}
				if (eventoCasa.getEsito() != null) {
					if (eventoCasa.getEsito().equals("1")) {
						vittorie++;
					}
				}
			}
			if (eventoTrasferta != null) {
				if(eventoTrasferta.getTerminato() == true) {
					i++;
				}
				if (eventoTrasferta.getEsito() != null) {
					if (eventoTrasferta.getEsito().equals("2")) {
						vittorie++;
					}
				}
			}
		}
		if (i != 0) {
			percentualeVittoria = (vittorie * 100) / i;
		}
		return percentualeVittoria;

	}

	public void aggiornaImmagine(String indirizzoImmagine, String username) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		User user = userPerUsername(username);
		user.setProfilePicturePath(indirizzoImmagine);
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}

	public List<User> listaUtenti() {
		List<User> utenti = new ArrayList();
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		utenti = em.createQuery("select u from User u", User.class).getResultList();
		em.close();
		return utenti;

	}

	public void modificaDati(String username, String email, String password, String nome, String cognome, String citta,
			String eta, String regione, String telefono, String profilePicturePath) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		User u = em.find(User.class, username);
		if (cognome != null) {
			u.setCognome(cognome);
		}
		if (citta != null) {
			u.setCitta(citta);
		}
		if (email != null) {
			u.setEmail(email);
		}
		if (eta != null) {
			u.setEta(Integer.parseInt(eta));
		}
		if (nome != null) {
			u.setNome(nome);
		}
		if (password != null) {
			u.setPassword(password);
		}
		if (regione != null) {
			u.setRegione(regione);
		}
		if (telefono != null) {
			u.setTelefono(telefono);
		}
		if (profilePicturePath != null) {
			u.setProfilePicturePath(profilePicturePath);
		}
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}

}