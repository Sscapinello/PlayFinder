package it.playfinder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nome;
	private int nGiocatori;
		
	//bi-directional many-to-one association to Squadra
	@OneToMany(mappedBy="modulo")
	private List<Squadra> squadras;	
	
	@OneToMany
	private List<GiocatoriRuolo> giocatoriruolo;
	
	public List<Squadra> getSquadras() {
		return this.squadras;
	}

	public void setSquadras(List<Squadra> squadras) {
		this.squadras = squadras;
	}

	public Squadra addSquadra(Squadra squadra) {
		getSquadras().add(squadra);
		squadra.setModulo(this);

		return squadra;
	}

	public Squadra removeSquadra(Squadra squadra) {
		getSquadras().remove(squadra);
		squadra.setModulo(null);

		return squadra;
	}

	public int getNome() {
		return nome;
	}

	public void setNome(int nome) {
		this.nome = nome;
	}

	public int getnGiocatori() {
		return nGiocatori;
	}

	public void setnGiocatori(int nGiocatori) {
		this.nGiocatori = nGiocatori;
	}

	public List<GiocatoriRuolo> getGiocatoriruolo() {
		return giocatoriruolo;
	}

	public void setGiocatoriruolo(List<GiocatoriRuolo> giocatoriruolo) {
		this.giocatoriruolo = giocatoriruolo;
	}	
}
