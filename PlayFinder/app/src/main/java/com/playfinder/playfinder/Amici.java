package com.playfinder.playfinder;

import android.media.Image;

/**
 * Created by itsadmin on 06/03/2018.
 */

public class Amici {
    int profilo;
    String nome;
    String username;

    public Amici (int profilo, String nome, String username){
        this.profilo = profilo;
        this.nome = nome;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProfilo() {

        return profilo;
    }

    public void setProfilo(int profilo) {
        this.profilo = profilo;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
