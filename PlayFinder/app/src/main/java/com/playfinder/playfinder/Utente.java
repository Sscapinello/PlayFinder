package com.playfinder.playfinder;

import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

/**
 * Created by itsadmin on 13/03/2018.
 */


public class Utente {
    @SerializedName("success")
    Boolean success;
    @SerializedName("messaggio")
    String messaggio;
    @SerializedName("nome")
    public String nome;
    @SerializedName("username")
    public String username;
    @SerializedName("cognome")
    public String cognome;
    @SerializedName("password")
    public String password;

    public Utente (String username, String nome, String cognome, String password) {
        this.password = username;
        this.nome = nome;
        this.cognome = cognome;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
