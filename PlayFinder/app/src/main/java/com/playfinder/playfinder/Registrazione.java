package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registrazione extends Activity {

    Retrofit regs = new Retrofit.Builder()
            .baseUrl("http://192.168.0.53:8080/PlayFinderWeb/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);


        TextView nomeText = findViewById(R.id.nome_text);
        final EditText nome =  findViewById(R.id.nome);
        nome.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView cognomeText =  findViewById(R.id.cognome_text);
        final EditText cognome = findViewById(R.id.cognome);
        cognome.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView etaText =  findViewById(R.id.eta_text);
        final EditText eta = findViewById(R.id.eta);
        eta.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView cittaText = findViewById(R.id.citta_text);
        final EditText citta = findViewById(R.id.citta);
        citta.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView regioneText = findViewById(R.id.regione_text);
        final EditText regione = findViewById(R.id.regione);
        regione.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView emailText = findViewById(R.id.email_text);
        final EditText email = findViewById(R.id.email);
        email.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView telefonoText = findViewById(R.id.telefono_text);
        final EditText telefono = findViewById(R.id.telefono);
        telefono.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView usernameText = findViewById(R.id.nome_text);
        final EditText username = findViewById(R.id.username);
        username.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView passwordText = findViewById(R.id.password_text);
        final EditText password = findViewById(R.id.password);
        password.setGravity(Gravity.CENTER_HORIZONTAL);
        TextView confpasswordText = findViewById(R.id.confpassword_text);
        final EditText confpassword = findViewById(R.id.confpassword);
        confpassword.setGravity(Gravity.CENTER_HORIZONTAL);
        Button signin = findViewById(R.id.registrazione);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adapter.insertData(nome.getText().toString(),cognome.getText().toString(),username.getText().toString(),email.getText().toString(),password.getText().toString(),
                //      citta.getText().toString(),eta.getText().toString(),regione.getText().toString(),telefono.getText().toString());
                if (nome.length() > 0) {
                    String Nome = nome.getText().toString();

                } else {
                    Toast.makeText(Registrazione.this, "Inserire un nome", Toast.LENGTH_LONG).show();
                    return;
                }
                if (cognome.length() > 0) {
                    String Cognome = cognome.getText().toString();
                } else {
                    Toast.makeText(Registrazione.this, "Inserire un cognome", Toast.LENGTH_LONG).show();
                    return;
                }

                if (Integer.parseInt(eta.getText().toString()) > 16) {

                } else {
                    Toast.makeText(Registrazione.this, "Devi avere almeno 16 anni per registrarti", Toast.LENGTH_LONG).show();
                    return;
                }
                if (citta.length() > 0) {
                    String Username = username.getText().toString();
                } else {
                    Toast.makeText(Registrazione.this, "Inserire una città valida", Toast.LENGTH_LONG).show();
                    return;
                }
                if (regione.length() > 0) {
                    String Regione = regione.getText().toString();

                } else {
                    Toast.makeText(Registrazione.this, "Inserisci una regione valida", Toast.LENGTH_LONG);
                    return;
                }
                if (telefono.length() > 0) {
                    String Telefono = telefono.getText().toString();
                } else {
                    Toast.makeText(Registrazione.this, "Inserire un numero di telefono valido", Toast.LENGTH_LONG).show();
                    return;
                }
                if (username.getText().toString().length() > 5) {

                } else {
                    Toast.makeText(Registrazione.this, "Inserisci un username di almento 5 caratteri", Toast.LENGTH_LONG).show();
                    return;
                }
                if (password.getText().toString().length() < 5) {
                    Toast.makeText(Registrazione.this, "Inseri una password di almeno 5 caratteri", Toast.LENGTH_LONG).show();
                    return;
                }
                if (confpassword.getText().toString().equals(password.getText().toString())) {

                } else {
                    Toast.makeText(Registrazione.this, "La password non corrisponde", Toast.LENGTH_LONG).show();
                    return;
                }
                MyApiEndpointInterface registrazione = regs.create(MyApiEndpointInterface.class);
                Call<Utente> call = registrazione.registrazione(nome.getText().toString(), cognome.getText().toString(), Integer.parseInt(eta.getText().toString()),regione.getText().toString(),
                                    citta.getText().toString(),username.getText().toString(),email.getText().toString(),telefono.getText().toString(), password.getText().toString());
                call.enqueue(new Callback<Utente>() {
                    @Override
                    public void onResponse(Call<Utente> call, Response<Utente> response) {
                        Toast.makeText(Registrazione.this, "Registrazione effettuata",Toast.LENGTH_LONG).show();
                        Intent complete = new Intent(Registrazione.this, Home.class);
                        complete.putExtra("username" ,username.getText().toString());
                        startActivity(complete);
                    }

                    @Override
                    public void onFailure(Call<Utente> call, Throwable t) {
                        Toast.makeText(Registrazione.this, "Nessuna connessione",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }

}