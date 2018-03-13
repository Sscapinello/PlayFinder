package it.playfinder.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.playfinder1.EntityFac;


/**
 * The persistent class for the evento database table.
 * 
 */
@Entity
@NamedQuery(name="Evento.findAll", query="SELECT e FROM Evento e")
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	private int durata;
	
	private String nome;

	private int rCasa;

	private int rTrasferta;
	
	private String password;

	private boolean privato;
	
	private String esito;

	@ManyToOne(cascade=CascadeType.ALL)
	private Campo campo;
	
	@OneToMany(mappedBy = "evento")
	private List<UserInEvento> userInEvento;
	
	@ManyToOne
	private Sport sport;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="squadraCasa")
	private Squadra squadraCasa;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="squadraTrasferta")
	private Squadra squadraTrasferta;

	public Evento() {
	}
	
	public String getDataStringa() {
		return sdf.format(this.data);
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
	public boolean getIniziato() {
		Instant instant = this.data.toInstant();
		return instant.isBefore(Instant.now());
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

	public int getrCasa() {
		return rCasa;
	}

	public void setrCasa(int rCasa) {
		this.rCasa = rCasa;
	}

	public int getrTrasferta() {
		return rTrasferta;
	}

	public void setrTrasferta(int rTrasferta) {
		this.rTrasferta = rTrasferta;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isPrivato() {
		return privato;
	}

	public void setPrivato(boolean privato) {
		this.privato = privato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<UserInEvento> getUserInEvento() {
		return userInEvento;
	}

	public void setAc(List<UserInEvento> ac) {
		this.userInEvento = ac;
	}

	public String getEsito() {
		return esito;
	}

	public void setEsito() {
		String esito = null;
		if(rCasa > rTrasferta) {
			esito = "1" ;
		}else if (rCasa == rTrasferta) {
			esito = "X";
		}else if(rCasa < rTrasferta) {
			esito = "2";
		}
		this.esito = esito;
	}

	public void setUserInEvento(List<UserInEvento> userInEvento) {
		this.userInEvento = userInEvento;
	}
	
 	

}