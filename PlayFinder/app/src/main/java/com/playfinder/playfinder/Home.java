package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends Activity {
    ImageButton profile;
    EditText ricerca;
    Button creaEvento;
    ImageButton lente;
    TextView eventiVicini;
    TextView eventiVari;
    ListView list1;
    ListView list2;
    TextView username;
    String u;


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.95:8080/Playfinder/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        u = getIntent().getExtras().getString("username");

        profile = findViewById(R.id.profile);
        ricerca = findViewById(R.id.ricerca);
        creaEvento = findViewById(R.id.creaEvento);
        lente = findViewById(R.id.lente);
        eventiVicini = findViewById(R.id.eventiVicini);
        eventiVari = findViewById(R.id.eventiVari);
        username = findViewById(R.id.username);
        username.setText(u);

        final ArrayList vicinanze = new ArrayList();
        list1 = this.findViewById(R.id.listVicini);
        final ArrayAdapter<Partita> adapter = new ArrayAdapter<Partita>(Home.this, R.layout.activity_adapter_storico,R.id.rS1, vicinanze);
        list1.setAdapter(adapter);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent evento = new Intent(Home.this, InfoEvento.class);
                startActivity(evento);
            }
        });


        MyApiEndpointInterface eventi = retrofit.create(MyApiEndpointInterface.class);
        Call<Partita> call = eventi.home();
        call.enqueue(new Callback<Partita>() {
            @Override
            public void onResponse(Call<Partita> call, Response<Partita> response) {
                if(response.isSuccessful()){
                    adapter.addAll(response.body());
                }else {
                    adapter.addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<Partita> call, Throwable t) {
                vicinanze.add("no connection");
            }
        });
        final ArrayList vari = new ArrayList();
        list2 = this.findViewById(R.id.listVari);
        final ArrayAdapter<Partita> adapter2 =new ArrayAdapter<Partita>(Home.this, R.layout.activity_adapter_storico,R.id.rS1, vari);
        list2.setAdapter(adapter2);
        MyApiEndpointInterface eventiVari = retrofit.create(MyApiEndpointInterface.class);
        call.clone().enqueue(new Callback<Partita>() {
            @Override
            public void onResponse(Call<Partita> call, Response<Partita> response) {
                if (response.isSuccessful()) {
                    adapter2.addAll(response.body());

                }else{
                    adapter2.addAll(response.body());
                }
            }
            @Override
            public void onFailure(Call<Partita> call, Throwable t) {
                vari.add("no connection");
            }
        });
       list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent evento = new Intent(Home.this, InfoEvento.class);
                evento.putExtra("evento", "");
                startActivity(evento);
            }
        });
        creaEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cE = new Intent (Home.this, CreaEvento.class);
                cE.putExtra("username", u);
                startActivity(cE);
            }
        });

        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent prof=new Intent (Home.this, Profilo.class);
                prof.putExtra("username", u);
                startActivity(prof);
          }

        });

    }
}