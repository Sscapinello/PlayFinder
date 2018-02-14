package it.playfinder1;



public class EsitoOperazione {
	private boolean success;
	private String messaggio;
	private Object oggettoRisultante;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessaggio() {
		return messaggio;
	}
	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}
	public Object getOggettoRisultante() {
		return oggettoRisultante;
	}
	public void setOggettoRisultante(Object oggettoRisultante) {
		this.oggettoRisultante = oggettoRisultante;
	}
	
}
