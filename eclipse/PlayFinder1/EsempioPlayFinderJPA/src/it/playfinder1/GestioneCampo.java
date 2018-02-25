package it.playfinder1;

import javax.persistence.EntityManager;

import it.playfinder.model.Campo;

public class GestioneCampo {
	
	public Campo creaCampo(String citta, String regione, String via, String nCivico) {
		EntityManager em = EntityFac.getInstance().getEm();
		Campo c = new Campo();
		c.setCitta(citta);
		c.setRegione(regione);
		c.setVia(via);
		c.setnCivico(nCivico);
		return c;
  }
}
