package it.playfinder.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.playfinder.model.Evento;
import it.playfinder1.EntityFac;
import it.playfinder1.GestioneEvento;

public class Test {

	public static void main(String[] args) {
		GestioneEvento ge = new GestioneEvento();
		List<Evento> eventi = ge.elencoEventi();
		for(Evento e  : eventi) {
			String nome = e.getNome();
			System.out.println(nome);
			}
		}
}
