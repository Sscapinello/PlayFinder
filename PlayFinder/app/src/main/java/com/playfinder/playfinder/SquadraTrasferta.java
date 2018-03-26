package com.playfinder.playfinder;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by itsadmin on 23/03/2018.
 */

public class SquadraTrasferta {
    @SerializedName("idSqudra")
    int idSquadra;
    @SerializedName("nome")
    String nome;
    @SerializedName("modulo")
    String modulo;
    @SerializedName("ruoli")
    ArrayList ruoli;

    public int getIdSquadra() {
        return idSquadra;
    }

    public void setIdSquadra(int idSquadra) {
        this.idSquadra = idSquadra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public ArrayList getRuoli() {
        return ruoli;
    }

    public void setRuoli(ArrayList ruoli) {
        this.ruoli = ruoli;
    }

    public SquadraTrasferta(int idSquadra, String nome, String modulo, ArrayList ruoli) {

        this.idSquadra = idSquadra;
        this.nome = nome;
        this.modulo = modulo;
        this.ruoli = ruoli;
    }
}
