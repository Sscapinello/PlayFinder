package it.playfinder.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
public class RuoloPartita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRuoloPartita;
	
	@ManyToOne
	private Ruolo ruolo;
	
	@ManyToOne
	private Squadra squadra;

	@ManyToMany(mappedBy="ruoliPartite")
	private List<User> users;

	public int getIdRuoloPartita() {
		return idRuoloPartita;
	}

	public void setIdRuoloPartita(int idRuolo) {
		this.idRuoloPartita = idRuolo;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public void setSquadra(Squadra squadra) {
		this.squadra = squadra;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}


}