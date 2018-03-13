package it.playfinder.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.playfinder1.EntityFac;

@Entity
public class UserInEvento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="username")
	@JsonIgnore
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idEvento")
	@JsonIgnore
	private Evento evento;
	
	private boolean amministratore = false;
	
	private boolean capitano = false;
	

	public UserInEvento nuovoPartecipante(User u, Evento e) {
		this.setEvento(e);
		this.setUser(u);
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public boolean isAmministratore() {
		return amministratore;
	}

	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}

	public boolean isCapitano() {
		return capitano;
	}

	public void setCapitano(boolean capitano) {
		this.capitano = capitano;
	}

	



}
