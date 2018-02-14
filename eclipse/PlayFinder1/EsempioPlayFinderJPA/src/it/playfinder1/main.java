package it.playfinder1;

import javax.persistence.EntityManager;

public class main {

	public static void main(String[] args) {
		EntityManager em = EntityFac.getInstance().getEm();
	}

}
