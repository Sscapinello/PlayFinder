package it.playfinder.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.playfinder1.EntityFac;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String password;

	private String citta;

	private String cognome;

	private String email;

	private int eta;

	private String nome;

	private String regione;

	private String telefono;
	
	private String profilePicturePath;
	
	
	//bi-directional one to many association to RuoloPartita
	@ManyToMany
	@JsonIgnore
	private List<RuoloPartita> ruoliPartite;
	
	@OneToMany(mappedBy = "utente2", cascade=CascadeType.ALL)
	private List<Amicizia> amici;
	
	@OneToMany(mappedBy = "utente1", cascade=CascadeType.ALL)
	private List<Amicizia> amicoDi;
	
	@OneToMany(mappedBy = "user")
	private List<UserInEvento> ac;
	
	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEta() {
		return this.eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegione() {
		return this.regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<RuoloPartita> getRuoliPartite() {
		return ruoliPartite;
	}

	public void setRuoliPartite(List<RuoloPartita> ruoloPartita) {
		this.ruoliPartite = ruoloPartita;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Amicizia> getAmici() {
		return amici;
	}

	public void setAmici(List<Amicizia> amici) {
		this.amici = amici;
	}
	
	public void addAmico(User u, boolean accettata) {
		Amicizia am = new Amicizia();
		am.setUtente1(this);
		am.setUtente2(u);
		am.setDataInizioAmicizia(new Date());
		am.setAccettata(accettata);
		
		amici.add(am);
		u.getAmicoDi().add(am);
	}
	public void removeAmico(User u) {
		Amicizia daRimuovere = null;
		for(Amicizia am : amici) {
			if (am.getUtente1().equals(u) || am.getUtente2().equals(u)) {
				daRimuovere = am;
				break;
			}
		}
		if (daRimuovere != null) {
			amici.remove(daRimuovere);
			u.getAmicoDi().remove(daRimuovere);
		}
	}

	public List<Amicizia> getAmicoDi() {
		return amicoDi;
	}

	public void setAmicoDi(List<Amicizia> amicoDi) {
		this.amicoDi = amicoDi;
	}


	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public List<UserInEvento> getAc() {
		return ac;
	}

	public void setAc(List<UserInEvento> ac) {
		this.ac = ac;
	}
	

	
}