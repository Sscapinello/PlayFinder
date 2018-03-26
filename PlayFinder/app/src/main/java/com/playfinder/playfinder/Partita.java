package com.playfinder.playfinder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by itsadmin on 06/03/2018.
 */

public class Partita {

    @SerializedName("idEvento")
    String idEvento;
    @SerializedName("data")
    String data;
    @SerializedName("durata")
    int durata;
    @SerializedName("nome")
    String nome;
    @SerializedName("rCasa")
    int rCasa;
    @SerializedName("rTrasferta")
    int rTrasferta;
    @SerializedName("password")
    String password;
    @SerializedName("privato")
    Boolean privato;
    @SerializedName("esito")
    String esito;
    @SerializedName("campo")
    Campo campo;
    @SerializedName("userInEvento")
    ArrayList userInEvento;
    @SerializedName("sport")
    Sport sport;
    @SerializedName("squadraCasa")
    SquadraCasa squadraCasa;
    @SerializedName("squdraTrasferta")
    SquadraTrasferta squadraTrasferta;
    @SerializedName("terminato")
    Boolean terminato;
    @SerializedName("rcasa")
    int rcasa;
    @SerializedName("rtrasferta")
    int rtrasferta;
    @SerializedName("iniziato")
    Boolean iniziato;
    @SerializedName("dataStinga")
    String dataStringa;

    public String getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(String idEvento) {
        this.idEvento = idEvento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPrivato() {
        return privato;
    }

    public void setPrivato(Boolean privato) {
        this.privato = privato;
    }

    public String getEsito() {
        return esito;
    }

    public void setEsito(String esito) {
        this.esito = esito;
    }

    public Campo getCampo() {
        return campo;
    }

    public void setCampo(Campo campo) {
        this.campo = campo;
    }

    public ArrayList getUserInEvento() {
        return userInEvento;
    }

    public void setUserInEvento(ArrayList userInEvento) {
        this.userInEvento = userInEvento;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public SquadraCasa getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(SquadraCasa squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public SquadraTrasferta getSquadraTrasferta() {
        return squadraTrasferta;
    }

    public void setSquadraTrasferta(SquadraTrasferta squadraTrasferta) {
        this.squadraTrasferta = squadraTrasferta;
    }

    public Boolean getTerminato() {
        return terminato;
    }

    public void setTerminato(Boolean terminato) {
        this.terminato = terminato;
    }

    public int getRcasa() {
        return rcasa;
    }

    public void setRcasa(int rcasa) {
        this.rcasa = rcasa;
    }

    public int getRtrasferta() {
        return rtrasferta;
    }

    public void setRtrasferta(int rtrasferta) {
        this.rtrasferta = rtrasferta;
    }

    public Boolean getIniziato() {
        return iniziato;
    }

    public void setIniziato(Boolean iniziato) {
        this.iniziato = iniziato;
    }

    public String getDataStringa() {
        return dataStringa;
    }

    public void setDataStringa(String dataStringa) {
        this.dataStringa = dataStringa;
    }

    public Partita(String idEvento, String data, int durata, String nome, int rCasa, int rTrasferta, String password, Boolean privato, String esito, Campo campo, ArrayList userInEvento, Sport sport, SquadraCasa squadraCasa, SquadraTrasferta squadraTrasferta, Boolean terminato, int rcasa, int rtrasferta, Boolean iniziato, String dataStringa) {

        this.idEvento = idEvento;
        this.data = data;
        this.durata = durata;
        this.nome = nome;
        this.rCasa = rCasa;
        this.rTrasferta = rTrasferta;
        this.password = password;
        this.privato = privato;
        this.esito = esito;
        this.campo = campo;
        this.userInEvento = userInEvento;
        this.sport = sport;
        this.squadraCasa = squadraCasa;
        this.squadraTrasferta = squadraTrasferta;
        this.terminato = terminato;
        this.rcasa = rcasa;
        this.rtrasferta = rtrasferta;
        this.iniziato = iniziato;
        this.dataStringa = dataStringa;
    }
}