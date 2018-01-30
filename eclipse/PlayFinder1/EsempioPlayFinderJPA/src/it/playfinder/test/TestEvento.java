package it.playfinder.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.Instant;

import org.junit.Test;

import it.playfinder.model.Campo;
import it.playfinder.model.Modulo;
import it.playfinder1.GestioneEventi;

public class TestEvento {

	@Test
	public void testCreazione() {
		GestioneEventi ge = new GestioneEventi();
		Campo c = new Campo();
		Modulo m = new Modulo();
		boolean esito = ge.creazioneEvento(1999/02/01, c, m, 125);
	}

}
