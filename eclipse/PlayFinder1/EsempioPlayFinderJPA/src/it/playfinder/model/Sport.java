package it.playfinder.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the sport database table.
 * 
 */
@Entity
@NamedQuery(name="Sport.findAll", query="SELECT s FROM Sport s")
public class Sport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nomeSport;

	private int nPartecipanti;
	
	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="sport")
	@JsonIgnore
	private List<Evento> eventos;


	@OneToMany(mappedBy = "sport")
	@JsonIgnore
	private List<Modulo> modulo;

	public Sport() {
	}

	public String getNomeSport() {
		return this.nomeSport;
	}

	public void setNomeSport(String nomeSport) {
		this.nomeSport = nomeSport;
	}

	public int getNPartecipanti() {
		return this.nPartecipanti;
	}

	public void setNPartecipanti(int nPartecipanti) {
		this.nPartecipanti = nPartecipanti;
	}

	public int getnPartecipanti() {
		return nPartecipanti;
	}

	public void setnPartecipanti(int nPartecipanti) {
		this.nPartecipanti = nPartecipanti;
	}

	public List<Modulo> getModulo() {
		return modulo;
	}

	public void setModulo(List<Modulo> modulo) {
		this.modulo = modulo;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setSport(this);

		return evento;
	}
	
	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setSport(null);

		return evento;
	}

}