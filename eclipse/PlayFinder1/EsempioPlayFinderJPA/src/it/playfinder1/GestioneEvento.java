package it.playfinder1;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import it.playfinder.model.UserInEvento;
import it.playfinder.model.Campo;
import it.playfinder.model.Evento;
import it.playfinder.model.GiocatoriRuolo;
import it.playfinder.model.Modulo;
import it.playfinder.model.RuoloPartita;
import it.playfinder.model.Sport;
import it.playfinder.model.Squadra;
import it.playfinder.model.User;

public class GestioneEvento {

	public Evento creazioneEvento(String name, Date data, Campo campo, Sport sport, int durata, User u) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		Squadra casa = new Squadra();
		Squadra trasferta = new Squadra();
		Evento e = new Evento();
		// Modulo m = moduloDefault(sport);
		e.setCampo(campo);
		e.setDurata(durata);
		e.setSport(em.find(Sport.class, sport.getNomeSport()));
		e.setData(data);
		e.setNome(name);
		u = em.find(User.class, u.getUsername());
		casa.creaSquadra("Team 1");
		trasferta.creaSquadra("Team 2");
		e.setSquadraCasa(casa);
		e.setSquadraTrasferta(trasferta);
		// casa.setModulo(m);
		// trasferta.setModulo(m);
		UserInEvento a = new UserInEvento();
		a.nuovoPartecipante(u, e);
		a.setAmministratore(true);
		// List<RuoloPartita> x = settaModulo(m, casa);
		// List<RuoloPartita> y = settaModulo(m, trasferta);
		/*
		 * for(RuoloPartita r : x) { em.persist(r); } for(RuoloPartita r : y) {
		 * em.persist(r); }
		 */
		em.persist(e);
		em.persist(a);
		em.getTransaction().commit();

		return e;
	}

	public Evento creazioneEvento(String name, Date data, Campo campo, Sport sport, int durata, User u,
			String password) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		Squadra casa = new Squadra();
		Squadra trasferta = new Squadra();
		Evento e = new Evento();
		e.setCampo(campo);
		e.setDurata(durata);
		e.setSport(em.find(Sport.class, sport.getNomeSport()));
		e.setData(data);
		e.setNome(name);
		e.setPassword(password);
		u = em.find(User.class, u.getUsername());
		casa.creaSquadra("Team 1");
		trasferta.creaSquadra("Team 2");
		e.setSquadraCasa(casa);
		e.setSquadraTrasferta(trasferta);
		UserInEvento a = new UserInEvento();
		a.setAmministratore(true);
		a.nuovoPartecipante(u, e);
		em.persist(e);
		em.persist(a);
		em.getTransaction().commit();

		return e;
	}

	public List<String> elencoSport() {
		List<String> sport = new ArrayList<String>();
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			Query query = em.createQuery("Select s.nomeSport FROM Sport s");
			sport = query.getResultList();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return sport;
	}

	public List<Evento> elencoEventi() {
		List<Evento> eventi = new ArrayList<Evento>();
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			Query query = em.createQuery("Select e FROM Evento e");
			eventi = query.getResultList();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return eventi;
	}

	public boolean aggiungiRisultato(Evento e, int rCasa, int rTrasferta) {
		EntityManager em = EntityFac.getInstance().getEm();
		e = em.find(Evento.class, e.getIdEvento());
		if (e.getTerminato()) {
			e.setRCasa(rCasa);
			e.setRTrasferta(rTrasferta);
			return true;
		}
		return false;
	}

	public List<Modulo> selezionaModulo(Evento e) {
		Sport s = e.getSport();
		return s.getModulo();
	}

	public boolean partecipaEvento(Evento evento, String username, Squadra squadra, RuoloPartita ruoloPartita) {
		EntityManager em = EntityFac.getInstance().getEm();
		GestioneEvento ge = new GestioneEvento();
		em.getTransaction().begin();
		Modulo modulo = squadra.getModulo();
		User user = em.find(User.class, username);
		int count = 0;
		UserInEvento x = ge.partecipa(username, evento.getIdEvento());
		List<UserInEvento> users = evento.getUserInEvento();
		if (x != null) {
			for (UserInEvento usr : users) {
				String uName = usr.getUser().getUsername();
				if (uName.equals(username)) {
					count = 1;
					UserInEvento f = usr;
					if (squadra.componenti(squadra).size() == 0) {
						f.setCapitano(true);
						em.merge(f);
					}
				}
			}
		}
			if (count == 0) {
				UserInEvento userInEvento = new UserInEvento();
				userInEvento.nuovoPartecipante(user, evento);
				if (squadra.componenti(squadra).size() == 0) {
					userInEvento.setCapitano(true);
				}
				em.persist(userInEvento);
			}
			int disponibiliModulo = 0;
			for (GiocatoriRuolo gr : modulo.getGiocatoriruolo()) {
				if (gr.getRuolo().getNome().equals(ruoloPartita.getRuolo().getNome())) {
					disponibiliModulo = gr.getnGiocatori();
				}
			}
			disponibiliModulo -= ruoloPartita.getUsers().size();
			if (disponibiliModulo > 0) {
				ruoloPartita.getUsers().add(user);
				user.getRuoliPartite().add(ruoloPartita);
				em.getTransaction().commit();
				return true;
			}
		
		return false;
	}

	/*
	 * public Modulo moduloDefault(Sport sport) { Modulo m = null; EntityManager em
	 * = EntityFac.getInstance().getEm();
	 * if(sport.getNomeSport().equals("Calcio a 5")) { m =
	 * em.createQuery("select m from Modulo m where m.nome='3-1'",
	 * Modulo.class).getSingleResult();
	 * }if(sport.getNomeSport().equals("Calcio a 7")) { m =
	 * em.createQuery("select m from Modulo m where m.nome='1-4-1'",
	 * Modulo.class).getSingleResult();
	 * }if(sport.getNomeSport().equals("Calcio a 11")){ m =
	 * em.createQuery("select m from Modulo m where m.nome='4-4-2'",
	 * Modulo.class).getSingleResult(); } return m; }
	 */

	public List<RuoloPartita> settaRuoloPartita(Modulo m, Squadra s, String nomeSquadra) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		List<RuoloPartita> rp = new ArrayList();
		List<GiocatoriRuolo> ge = m.getGiocatoriruolo();
		s.setModulo(m);
		s.setNome(nomeSquadra);
		for (GiocatoriRuolo gr : ge) {
			RuoloPartita r = new RuoloPartita();
			r.setRuolo(gr.getRuolo());
			r.setSquadra(s);
			rp.add(r);
		}
		for (RuoloPartita r : rp) {
			em.persist(r);
		}
		em.merge(s);
		em.getTransaction().commit();
		return rp;

	}

	public boolean rimuoviEvento(Evento e, User u) {
		GestioneEvento ge = new GestioneEvento();
		EntityManager em = EntityFac.getInstance().getEm();
		e = em.find(Evento.class, e.getIdEvento());
		u = em.find(User.class, u.getUsername());
		UserInEvento ue = null;
		ue = ge.partecipa(u.getUsername(), e.getIdEvento());
		if (ue.isAmministratore() == true) {
			em.getTransaction().begin();
			em.remove(e);
			return true;
		}
		return false;
	}

	public Sport sportPerNome(String nomeSport) {
		Sport sport = null;
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			sport = em.createQuery("select s from Sport s where s.nomeSport=:nomeSport", Sport.class)
					.setParameter("nomeSport", nomeSport).getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return sport;
	}

	public Squadra squadraPerId(int idSquadra) {
		Squadra s = null;
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			s = em.createQuery("select s from Squadra s where s.idSquadra=:idSquadra", Squadra.class)
					.setParameter("idSquadra", idSquadra).getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return s;
	}

	public Evento eventoPerId(int idEvento) {
		Evento e = null;
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			e = em.createQuery("select e from Evento e where e.idEvento=:idEvento", Evento.class)
					.setParameter("idEvento", idEvento).getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return e;
	}

	public RuoloPartita ruoloPartitaPerId(int idRuoloPartita) {
		RuoloPartita rp = null;
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			rp = em.createQuery("select r from RuoloPartita r where r.idRuoloPartita=:idRuoloPartita",
					RuoloPartita.class).setParameter("idRuoloPartita", idRuoloPartita).getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return rp;
	}

	public UserInEvento partecipa(String username, int idEvento) {
		EntityManager em = EntityFac.getInstance().getEm();
		UserInEvento userInEvento = null;
		GestioneEvento gestioneEvento = new GestioneEvento();
		GestioneAccount gestioneAccount = new GestioneAccount();
		Evento evento = gestioneEvento.eventoPerId(idEvento);
		User User = gestioneAccount.userPerUsername(username);
		List<UserInEvento> users = evento.getUserInEvento();
		for (UserInEvento u : users) {
			if (u.getUser().getUsername().equals(username)) {
				userInEvento = u;
			}
		}
		return userInEvento;
	}
	
	public List<Evento> eventiDaAggiornare(User u) {
		EntityManager em = EntityFac.getInstance().getEm();
		List<Evento> eventi = new ArrayList();
		List<UserInEvento> userInEvento = u.getUserInEvento();
		for(UserInEvento user : userInEvento) {
			if(user.isAmministratore() && user.getEvento().getTerminato() == true && user.getEvento().getEsito() == null) {
				eventi.add(user.getEvento());
			}
		}
		return eventi;
		
	}
	
	public void settaRisultato(int idEvento, int rCasa, int rTrasferta) {
		EntityManager em = EntityFac.getInstance().getEm();
		em.getTransaction().begin();
		Evento evento = eventoPerId(idEvento);
		evento.setrCasa(rCasa);
		evento.setrTrasferta(rTrasferta);
		evento.setEsito();
		em.merge(evento);
		em.getTransaction().commit();
	}
	


}
