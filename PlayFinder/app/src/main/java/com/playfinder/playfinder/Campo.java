package com.playfinder.playfinder;

import com.google.gson.annotations.SerializedName;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class Campo {

    @SerializedName("idCampo")
    int idCampo;
    @SerializedName("citta")
    String citta;
    @SerializedName("regione")
    String regione;
    @SerializedName("via")
    String via;
    @SerializedName("esito")
    String esito;

    public Campo(int idCampo, String citta, String regione, String via, String esito) {
        this.idCampo = idCampo;
        this.citta = citta;
        this.regione = regione;
        this.via = via;
        this.esito = esito;
    }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }
}
