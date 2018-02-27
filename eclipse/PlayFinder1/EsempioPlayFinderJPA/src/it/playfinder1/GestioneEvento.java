package it.playfinder1;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

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
		Modulo m = moduloDefault(sport);
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
		casa.setModulo(m);
		trasferta.setModulo(m);
		UserInEvento a = new UserInEvento();
		a.nuovoPartecipante(u, e);
		a.setAmministratore(true);
		a.setCapitano(true);
		em.persist(e);
		em.persist(a);
		em.getTransaction().commit();

		return e;
	}
	public Evento creazioneEvento(String name, Date data, Campo campo, Sport sport, int durata, User u, String password) {
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
		a.setCapitano(true);
		a.nuovoPartecipante(u, e);
		em.persist(e);
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

	
	
	
	public void fineEvento(Evento e) {
		if(e.getTerminato()==true) {
			EntityManager em = EntityFac.getInstance().getEm();
			
			
		}
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
	public List<Modulo> moduliEvento(Evento e) {
		Sport s = e.getSport();
		return s.getModulo();
	}
	
	public boolean partecipaEvento(Evento e, String username, Squadra s, RuoloPartita rp) {
		EntityManager em = EntityFac.getInstance().getEm();
		e = em.find(Evento.class, e.getIdEvento());
		s = em.find(Squadra.class, s.getNome());
		Modulo m = s.getModulo(); 
		User u = em.find(User.class, username);
		UserInEvento ac = new UserInEvento();
		ac.nuovoPartecipante(u, e);
		if(rp.getUsers().size()==0) {
			ac.setCapitano(true);
		}
		int disponibiliModulo = 0;
		for(GiocatoriRuolo gr : m.getGiocatoriruolo()) {
			if(gr.getRuolo().equals(rp.getRuolo())) {
				disponibiliModulo = gr.getnGiocatori();
			}
		}
		disponibiliModulo -= rp.getUsers().size();
		if (disponibiliModulo > 0) {
			// partecipo
			em.getTransaction().begin();
			rp.getUsers().add(u);
			u.getRuoliPartite().add(rp);
			return true;
		}
		return false;
	
	}

	
	
	public Modulo moduloDefault(Sport sport) {
		Modulo m = null;
		EntityManager em = EntityFac.getInstance().getEm();
		if(sport.getNomeSport().equals("Calcio a 5")) {
			m = em.createQuery("select m from Modulo m where m.nome='3-1'", Modulo.class).getSingleResult();
		}if(sport.getNomeSport().equals("Calcio a 7")) {
			m = em.createQuery("select m from Modulo m where m.nome='1-4-1'", Modulo.class).getSingleResult();
		}if(sport.getNomeSport().equals("Calcio a 11")){
			m = em.createQuery("select m from Modulo m where m.nome='4-4-2'", Modulo.class).getSingleResult();
		}
		return m;
	}
	
	public boolean rimuoviEvento (Evento e, User u) {
		EntityManager em = EntityFac.getInstance().getEm();
		e = em.find(Evento.class, e.getIdEvento());
		u = em.find(User.class, u.getUsername());
		UserInEvento ue = null;
		ue = ue.haPartecipato(u, e);
		if(ue.isAmministratore()==true) {
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


}
