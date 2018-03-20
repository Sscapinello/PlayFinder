package it.playfinder.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import it.playfinder.model.Evento;
import it.playfinder.model.User;
import it.playfinder1.EntityFac;
import it.playfinder1.GestioneAccount;
import it.playfinder1.GestioneEvento;

public class Test {

	public static void main(String[] args) {
		GestioneAccount ga = new GestioneAccount();
		List<User> utenti = new ArrayList();
		utenti = ga.listaUtenti();
		for(User utente : utenti) {
		System.out.println(utente);
		}
			}

}
