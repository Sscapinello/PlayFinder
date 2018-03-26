package com.playfinder.playfinder;

import com.google.gson.annotations.SerializedName;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class Sport {
    @SerializedName("nomeSport")
    String nomeSport;
    @SerializedName("nPartecipanti")
    int nPartecipanti;
    @SerializedName("npartecipanti")
    int npartecipanti;

    public String getNomeSport() {
        return nomeSport;
    }

    public void setNomeSport(String nomeSport) {
        this.nomeSport = nomeSport;
    }

    public int getnPartecipanti() {
        return nPartecipanti;
    }

    public void setnPartecipanti(int nPartecipanti) {
        this.nPartecipanti = nPartecipanti;
    }

    public int getNpartecipanti() {
        return npartecipanti;
    }

    public void setNpartecipanti(int npartecipanti) {
        this.npartecipanti = npartecipanti;
    }

    public Sport(String nomeSport, int nPartecipanti, int npartecipanti) {

        this.nomeSport = nomeSport;
        this.nPartecipanti = nPartecipanti;
        this.npartecipanti = npartecipanti;
    }
}
