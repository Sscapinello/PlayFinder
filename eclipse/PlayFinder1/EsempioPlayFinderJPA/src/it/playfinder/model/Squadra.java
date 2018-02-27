package it.playfinder.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the squadra database table.
 * 
 */
@Entity
@NamedQuery(name="Squadra.findAll", query="SELECT s FROM Squadra s")
public class Squadra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSquadra;
	
	private String nome;

	//bi-directional one-to-one association to Evento
	@OneToOne(mappedBy="squadraCasa")
	@JsonIgnore
	private Evento eventoCasa;

	//bi-directional one-to-one association to Evento
	@OneToOne(mappedBy="squadraTrasferta")
	@JsonIgnore
	private Evento eventoTrasferta;

	//bi-directional many-to-one association to Sport
	@ManyToOne
	private Modulo modulo;
	
	@OneToMany(mappedBy="squadra")
	private List<RuoloPartita> ruoli;
	
	public Squadra creaSquadra(String nomeSquadra) {
		this.setNome(nomeSquadra);
		return this;
	}


	public Squadra() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		String sport = modulo.getSport().getNomeSport();
		if(sport.equals("Calcio a 7")|| sport.equals("Calcio a 11")) {
			List<GiocatoriRuolo> portieri = new ArrayList();
			List<GiocatoriRuolo> difensori = new ArrayList();
			List<GiocatoriRuolo> centrocampisti = new ArrayList();
			List<GiocatoriRuolo> attaccanti = new ArrayList();
		}
		this.modulo = modulo;
	}

	public Evento getEventoCasa() {
		return eventoCasa;
	}

	public void setEventoCasa(Evento eventoCasa) {
		this.eventoCasa = eventoCasa;
	}

	public Evento getEventoTrasferta() {
		return eventoTrasferta;
	}

	public void setEventoTrasferta(Evento eventoTrasferta) {
		this.eventoTrasferta = eventoTrasferta;
	}

	public List<RuoloPartita> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<RuoloPartita> ruoli) {
		this.ruoli = ruoli;
	}
	

	public RuoloPartita addRuolo(RuoloPartita ruoloPartita) {
		getRuoli().add(ruoloPartita);
		ruoloPartita.setSquadra(this);

		return ruoloPartita;
	}

	public RuoloPartita removeRuolo(RuoloPartita ruoloPartita) {
		getRuoli().remove(ruoloPartita);
		ruoloPartita.setSquadra(null);

		return ruoloPartita;
	}	
	
	public List<User> componenti(Squadra s){
		List<User> componenti = new ArrayList();
		for(RuoloPartita rp : s.getRuoli()) {
			RuoloPartita x = rp;
			for(User u : rp.getUsers()) {
				componenti.add(u);
			}
		}
		return componenti;
	}

}