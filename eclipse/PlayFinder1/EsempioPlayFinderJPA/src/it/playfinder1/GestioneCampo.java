package it.playfinder1;

import javax.persistence.EntityManager;

import it.playfinder.model.Campo;

public class GestioneCampo {
	public boolean creaCampo(String citta, String regione, String via, String nTel) {
		Campo c = new Campo();
		c.setCitta(citta);
		c.setnTel(nTel);
		c.setRegione(regione);
		c.setVia(via);
		return false;
	}
}
