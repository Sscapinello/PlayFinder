import java.util.*;

public class evento {

	private String sport, nomeCasa, nomeTrasferta;
	private Date giorno;
	private double durata;
	private int nPartecipanti, idEvento, rCasa, rTrasferta;
	private boolean terminato = false;
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getNomeCasa() {
		return nomeCasa;
	}
	public void setNomeCasa(String nomeCasa) {
		this.nomeCasa = nomeCasa;
	}
	public String getNomeTrasferta() {
		return nomeTrasferta;
	}
	public void setNomeTrasferta(String nomeTrasferta) {
		this.nomeTrasferta = nomeTrasferta;
	}
	public Date getGiorno() {
		return giorno;
	}
	public void setGiorno(Date giorno) {
		this.giorno = giorno;
	}
	public double getDurata() {
		return durata;
	}
	public void setDurata(double durata) {
		this.durata = durata;
	}
	public int getnPartecipanti() {
		return nPartecipanti;
	}
	public void setnPartecipanti(int nPartecipanti) {
		this.nPartecipanti = nPartecipanti;
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public int getrCasa() {
		return rCasa;
	}
	public void setrCasa(int rCasa) {
		this.rCasa = rCasa;
	}
	public int getrTrasferta() {
		return rTrasferta;
	}
	public void setrTrasferta(int rTrasferta) {
		this.rTrasferta = rTrasferta;
	}
	public boolean isTerminato() {
		return terminato;
	}
	public void setTerminato(boolean terminato) {
		this.terminato = terminato;
	}
}
