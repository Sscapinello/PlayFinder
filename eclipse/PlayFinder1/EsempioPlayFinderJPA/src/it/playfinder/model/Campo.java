package it.playfinder.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the campo database table.
 * 
 */
@Entity
@NamedQuery(name="Campo.findAll", query="SELECT c FROM Campo c")
public class Campo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCampo;

	private String citta;

	private String regione;

	private String via;
	
	private String nTel;

	//bi-directional many-to-one association to Evento
	@OneToMany(mappedBy="campo")
	private List<Evento> eventos;

	public Campo() {
	}

	public int getIdCampo() {
		return this.idCampo;
	}

	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getRegione() {
		return this.regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setCampo(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setCampo(null);

		return evento;
	}

	public String getnTel() {
		return this.nTel;
	}

	public void setnTel(String nTel) {
		this.nTel = nTel;
	}

}