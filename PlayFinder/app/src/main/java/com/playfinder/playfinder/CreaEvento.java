package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreaEvento extends Activity {
    ImageView logo;
    Spinner categoriaSpinner;
    TextView cateoria;
    EditText editLuogo;
    TextView luogo;
    TextView orario;
    EditText editOrario;
    TextView partecipanti;
    EditText editPartecipanti;
    TextView privato;
    CheckBox checkPrivato;
    TextView password;
    EditText editPassword;
    Button crea;
    EditText durata;
    EditText editRegione;
    TextView nCivico;
    EditText editCivico;
    String u = getIntent().getExtras().getString("username");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);



        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.53:8080/PlayFinderWeb")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        logo = findViewById(R.id.logo);
        categoriaSpinner = findViewById(R.id.categoriaSpinner);
        cateoria = findViewById(R.id.categoria);
        editLuogo = findViewById(R.id.editLuogo);
        luogo = findViewById(R.id.luogo);
        orario = findViewById(R.id.orario);
        editOrario = findViewById(R.id.editOrario);
        partecipanti = findViewById(R.id.textPartecipanti);
        editPartecipanti = findViewById(R.id.editPartecipanti);
        privato = findViewById(R.id.privato);
        checkPrivato = findViewById(R.id.checkPrivato);
        password = findViewById(R.id.password);
        editPassword = findViewById(R.id.editPass);
        crea = findViewById(R.id.crea);
        durata = findViewById(R.id.editDurata);
        editRegione = findViewById(R.id.editRegione);
        nCivico = findViewById(R.id.nCivico);
        editCivico = findViewById(R.id.edit);

        editPartecipanti.setInputType(InputType.TYPE_CLASS_NUMBER);
        editOrario.setInputType(InputType.TYPE_CLASS_DATETIME);
        editLuogo.setInputType(InputType.TYPE_CLASS_TEXT);
        if (checkPrivato.isChecked() == false) {
            password.setEnabled(false);
        } else {
            password.setEnabled(true);
        }


        String[] arraySpinner = new String[]{"Calcio a 11", "Calcio a 7", "Calcio a 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arraySpinner);
        categoriaSpinner.setAdapter(adapter);

        crea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Loc = editLuogo.getText().toString();

                String D = editOrario.getText().toString();

                String Pla = editPartecipanti.getText().toString();
                if (password.isEnabled() == true) {
                    if (password.length() == 0) {
                        Toast NoPass = Toast.makeText(CreaEvento.this,"Inserisci una password valida", Toast.LENGTH_LONG);
                        NoPass.show();
                    }
                } else if(password.length() <= 10) {
                    editPassword.setInputType(InputType.TYPE_CLASS_TEXT);
                    String Psw = editPassword.getText().toString();
                } else {
                  Toast TooLong = Toast.makeText(CreaEvento.this, "Password troppo lunga", Toast.LENGTH_LONG);
                  TooLong.show();
                }
                MyApiEndpointInterface nuovoEvento = retrofit.create(MyApiEndpointInterface.class);
                Call<Partita> creaEvento = nuovoEvento.creaEvento("", editPassword.getText().toString(), editOrario.getText().toString(), 55, checkPrivato.isChecked(), editLuogo.getText().toString(), "", "", categoriaSpinner.getSelectedItem().toString());
                creaEvento.enqueue(new Callback<Partita>() {
                    @Override
                    public void onResponse(Call<Partita> call, Response<Partita> response) {
                        Toast.makeText(CreaEvento.this, "Evento creato con successo", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(CreaEvento.this, Home.class);
                        intent.putExtra("username", u);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Partita> call, Throwable t) {
                        Toast.makeText(CreaEvento.this, "Nessuna connessione", Toast.LENGTH_LONG).show();
                    }
                });
            }


        });
    }
}