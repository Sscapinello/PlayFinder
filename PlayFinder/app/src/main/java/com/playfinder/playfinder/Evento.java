package com.playfinder.playfinder;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by itsadmin on 20/02/2018.
 */

public class Evento extends Activity {
    /*@SerializedName("Categoria")
    public String sport;
    @SerializedName("Luogo")
    public String luogo;
    @SerializedName("Orario")
    public String data;
    @SerializedName("Partecipanti")
    public String partecipanti;
    @SerializedName("Privato")
    public String privato;
    @SerializedName("Password")
    public String password;*/
    ImageView logo;
    Spinner sport;
    TextView luogoText;
    EditText luogo;
    TextView orarioText;
    EditText orario;
    TextView partecipantiText;
    EditText partecipanti;
    TextView privatoText;
    CheckBox privato;
    TextView passwordText;
    EditText password;
    Button crea;
    EditText durata;
    EditText editRegione;
    TextView nCivico;
    EditText editCivico;

    Retrofit creaEvento = new Retrofit.Builder()
            .baseUrl("http://192.168.0.53:8080/PlayFinderWeb/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        logo = findViewById(R.id.logo);
        sport = findViewById(R.id.categoriaSpinner);
        luogoText = findViewById(R.id.luogo);
        luogo = findViewById(R.id.editLuogo);
        orarioText = findViewById(R.id.orario);
        orario = findViewById(R.id.editOrario);
        partecipantiText = findViewById(R.id.textPartecipanti);
        partecipanti = findViewById(R.id.editPartecipanti);
        privatoText = findViewById(R.id.privato);
        privato = findViewById(R.id.checkPrivato);
        passwordText = findViewById(R.id.passwordText);
        password = findViewById(R.id.password);
        crea= findViewById(R.id.crea);
        durata = findViewById(R.id.editDurata);
        editRegione = findViewById(R.id.editRegione);
        nCivico = findViewById(R.id.nCivico);


        crea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApiEndpointInterface crea = creaEvento.create(MyApiEndpointInterface.class);
            }
        });
    }

}
