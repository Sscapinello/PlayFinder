package it.playfinder.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NoResultException;

import it.playfinder1.EntityFac;

@Entity
public class UserInEvento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="username")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idEvento")
	private Evento evento;
	
	private boolean amministratore = false;
	
	private boolean capitano = false;

	public UserInEvento nuovoPartecipante(User u, Evento e) {
		this.setEvento(e);
		this.setUser(u);
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	public UserInEvento haPartecipato(User u, Evento e) {
		UserInEvento ac = null;
		String username = u.getUsername();
		int idEvento = e.getIdEvento();
		try {
			EntityManager em = EntityFac.getInstance().getEm();
			ac = em.createQuery("select ue from UserInEvento ue where ue.username=:username and ue.idEvento=:idEvento", UserInEvento.class)
					.getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		}
		return ac;
	}


	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public boolean isAmministratore() {
		return amministratore;
	}

	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}

	public boolean isCapitano() {
		return capitano;
	}

	public void setCapitano(boolean capitano) {
		this.capitano = capitano;
	}



}
