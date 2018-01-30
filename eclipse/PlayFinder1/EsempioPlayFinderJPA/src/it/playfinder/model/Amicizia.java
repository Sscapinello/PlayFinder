package it.playfinder.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Amicizia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAmicizia;
	
	@ManyToOne
	private User utente1;
	@ManyToOne
	private User utente2;
	
	private boolean accettata;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInizioAmicizia;

	public int getIdAmicizia() {
		return idAmicizia;
	}

	public void setIdAmicizia(int idAmicizia) {
		this.idAmicizia = idAmicizia;
	}

	public User getUtente1() {
		return utente1;
	}

	public void setUtente1(User utente1) {
		this.utente1 = utente1;
	}

	public User getUtente2() {
		return utente2;
	}

	public void setUtente2(User utente2) {
		this.utente2 = utente2;
	}

	public boolean isAccettata() {
		return accettata;
	}

	public void setAccettata(boolean accettata) {
		this.accettata = accettata;
	}

	public Date getDataInizioAmicizia() {
		return dataInizioAmicizia;
	}

	public void setDataInizioAmicizia(Date dataInizioAmicizia) {
		this.dataInizioAmicizia = dataInizioAmicizia;
	}

}
