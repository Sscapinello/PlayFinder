package com.playfinder.playfinder;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by itsadmin on 22/03/2018.
 */


public class OggettoRisultante {
@SerializedName("username")
    String username;
@SerializedName("password")
    String password;
@SerializedName("citta")
    String citta;
@SerializedName("cognome")
    String cognome;
@SerializedName("email")
    String email;
@SerializedName("eta")
    String eta;
@SerializedName("nome")
    String nome;
@SerializedName("regione")
    String regione;
@SerializedName("telefono")
    String telefono;
@SerializedName("profilePicturePath")
    String profilePicturePath;
/*@SerializedName("amici")
    ArrayList <String> amici;
@SerializedName("amicoDi")
    ArrayList <String> amicoDi;*/
@SerializedName("userInEvento")
    ArrayList <UserInEvento> userInEvento;

    public OggettoRisultante(String username, String password, String citta, String cognome, String email, String eta, String nome, String regione, String telefono, String profilePicturePath, ArrayList <String> amici, ArrayList <String> amicoDi, ArrayList <UserInEvento> userInEvento) {
        this.username = username;
        this.password = password;
        this.citta = citta;
        this.cognome = cognome;
        this.email = email;
        this.eta = eta;
        this.nome = nome;
        this.regione = regione;
        this.telefono = telefono;
        this.profilePicturePath = profilePicturePath;
        //this.amici = amici;
        //this.amicoDi = amicoDi;
        this.userInEvento = userInEvento;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    /*public ArrayList<String> getAmici() {
        return amici;
    }

    public void setAmici(ArrayList<String> amici) {
        this.amici = amici;
    }

    public ArrayList<String> getAmicoDi() {
        return amicoDi;
    }

    public void setAmicoDi(ArrayList<String> amicoDi) {
        this.amicoDi = amicoDi;
    }*/

    public ArrayList<UserInEvento> getUserInEvento() {
        return userInEvento;
    }

    public void setUserInEvento(ArrayList<UserInEvento> userInEvento) {
        this.userInEvento = userInEvento;
    }
}
