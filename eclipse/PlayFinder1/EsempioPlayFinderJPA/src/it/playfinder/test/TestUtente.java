package it.playfinder.test;

import static org.junit.Assert.*;

import org.junit.Test;

import it.playfinder1.*;

public class TestUtente {

	@Test
	public void testRegistrazione() {
		GestioneAccount ga = new GestioneAccount();
		boolean esito = ga.registrazione("marco@gmail.com", "marcotossico", "marcodrogato", "marco", "inzoli", "milano", 20, "lombardia", "3402586596");
				assertTrue("Esito registrazione errato", esito == true);
	}
	@Test
	public void testLogin() {
		GestioneAccount ga = new GestioneAccount();
		boolean esito = ga.login("blabla", "pwd");
		assertTrue("login fallito", esito == false);
	}
	@Test
	public void testAggiungiAmico() {
		GestioneAccount ga = new GestioneAccount();
		ga.aggiungiAmico("marcotossico", "giovanni");
	}
}
