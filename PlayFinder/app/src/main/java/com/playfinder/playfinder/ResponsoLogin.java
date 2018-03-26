package com.playfinder.playfinder;

import com.google.gson.annotations.SerializedName;

/**
 * Created by itsadmin on 22/03/2018.
 */

public class ResponsoLogin {

    @SerializedName("success")
    boolean success;
    @SerializedName("messaggio")
    String messaggio;
    @SerializedName("oggettoRisultante")
    OggettoRisultante oggettoRisultante;

    public ResponsoLogin(boolean success, String messaggio, OggettoRisultante oggettoRisultante) {
        this.success = success;
        this.messaggio = messaggio;
        this.oggettoRisultante = oggettoRisultante;
    }

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

    public OggettoRisultante getOggettoRisultante() {
        return oggettoRisultante;
    }

    public void setOggettoRisultante(OggettoRisultante oggettoRisultante) {
        this.oggettoRisultante = oggettoRisultante;
    }
}
