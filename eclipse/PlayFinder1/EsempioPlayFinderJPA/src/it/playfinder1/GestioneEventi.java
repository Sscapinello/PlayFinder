package it.playfinder1;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import it.playfinder.model.Campo;
import it.playfinder.model.Evento;
import it.playfinder.model.GiocatoriRuolo;
import it.playfinder.model.Modulo;
import it.playfinder.model.RuoloPartita;
import it.playfinder.model.Sport;
import it.playfinder.model.Squadra;
import it.playfinder.model.User;

public class GestioneEventi {

	public boolean creazioneEvento(Date data, Campo campo, Sport sport, int durata, User u) {
		Evento e = new Evento();
		e.setCampo(campo);
		e.setDurata(durata);
		e.setSport(sport);
		e.setData(data);
		u.setAmministratore(true);
		u.setCapitano(true);
		return true;

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
		if(rp.getUsers().size()==0) {
			u.setCapitano(true);
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
	public boolean rimuoviEvento (Evento e, User u) {
		EntityManager em = EntityFac.getInstance().getEm();
		e = em.find(Evento.class, e.getIdEvento());
		if(u.isAmministratore()==true) {
			em.getTransaction().begin();
			em.remove(e);
			return true;
		}
		return false;
		
	}
}
