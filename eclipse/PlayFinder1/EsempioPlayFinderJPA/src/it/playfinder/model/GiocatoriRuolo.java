package it.playfinder.model;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class GiocatoriRuolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int nGiocatori;

	@ManyToOne
	private Ruolo ruolo;

	@ManyToOne
	private Modulo modulo;

	public GiocatoriRuolo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getnGiocatori() {
		return nGiocatori;
	}

	public void setnGiocatori(int nGiocatori) {
		this.nGiocatori = nGiocatori;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}
