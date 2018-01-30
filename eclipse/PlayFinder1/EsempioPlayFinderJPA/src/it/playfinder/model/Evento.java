package it.playfinder.model;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private int durata;


	private int rCasa;

	private int rTrasferta;

	//bi-directional many-to-one association to Campo
	@ManyToOne
	private Campo campo;
	
	@ManyToOne
	private Sport sport;

	//bi-directional many-to-one association to Squadra
	@OneToOne
	@JoinColumn(name="squadraCasa")
	private Squadra squadraCasa;

	//bi-directional many-to-one association to Squadra
	@OneToOne
	@JoinColumn(name="squadraTrasferta")
	private Squadra squadraTrasferta;

	public Evento() {
	}

	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getDurata() {
		return this.durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}


	public int getRCasa() {
		return this.rCasa;
	}

	public void setRCasa(int rCasa) {
		this.rCasa = rCasa;
	}

	public int getRTrasferta() {
		return this.rTrasferta;
	}

	public void setRTrasferta(int rTrasferta) {
		this.rTrasferta = rTrasferta;
	}

	public boolean getTerminato() {
		Instant instant = this.data.toInstant();
		Instant fineEvento = instant.plus(durata, ChronoUnit.MINUTES);
		
		return fineEvento.isBefore(Instant.now());
	}

	public Campo getCampo() {
		return this.campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	public Squadra getSquadraCasa() {
		return squadraCasa;
	}

	public void setSquadraCasa(Squadra squadraCasa) {
		this.squadraCasa = squadraCasa;
	}

	public Squadra getSquadraTrasferta() {
		return squadraTrasferta;
	}

	public void setSquadraTrasferta(Squadra squadraTrasferta) {
		this.squadraTrasferta = squadraTrasferta;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}

}