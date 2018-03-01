package it.playfinder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	@OneToMany(mappedBy = "ruolo")
	@JsonIgnore
	private List<RuoloPartita> ruoliPartita;

	@OneToMany(mappedBy = "ruolo")
	private List<GiocatoriRuolo> giocatoriRuolo;

	public Ruolo() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
