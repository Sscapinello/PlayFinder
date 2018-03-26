package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends Activity {

    TextView username;
    EditText usernametext;
    TextView password;
    EditText passwordText;
    Button accedi;
    TextView account;
    Button registrati;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.95:8080/PlayFinderWeb/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        usernametext = findViewById(R.id.usernameText);
        password = findViewById(R.id.password);
        passwordText = findViewById(R.id.passwordText);
        accedi = findViewById(R.id.accedi);
        account = findViewById(R.id.account);
        registrati = findViewById(R.id.registrati);


        accedi.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {

            MyApiEndpointInterface login = retrofit.create(MyApiEndpointInterface.class);
            Call<ResponsoLogin> call = login.login(usernametext.getText().toString(), passwordText.getText().toString());


                call.enqueue(new Callback<ResponsoLogin>() {
                    @Override
                    public void onResponse(Call<ResponsoLogin> call, Response<ResponsoLogin> response) {

                        ResponsoLogin u = response.body();

                        String us = u.getOggettoRisultante().getUsername();
                        String p = u.getOggettoRisultante().getPassword();



                        if (us.equals(usernametext.getText().toString()) && p.equals(passwordText.getText().toString())) {

                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_LONG).show();
                            Intent logSuc = new Intent(Login.this, Home.class);
                            logSuc.putExtra("username", us);
                            startActivity(logSuc);

                        } else {
                            Toast.makeText(Login.this, "Wrong Credentials", Toast.LENGTH_LONG).show();
                            Log.e("Response","fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponsoLogin> call, Throwable t) {
                        Toast.makeText(Login.this, "Nessuna connessione al server", Toast.LENGTH_LONG).show();
                    }

                });

             }



        });


        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Rgst = new Intent(Login.this, Registrazione.class);
                startActivity(Rgst);
            }
        });
    }
}
