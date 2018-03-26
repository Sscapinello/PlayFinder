package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentAmici extends Fragment {

    Retrofit amici = new Retrofit.Builder()
            .baseUrl("http://192.168.0.95:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public FragmentAmici(){

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_fragment_amici, container, false);

        final ListView listview = rootView.findViewById(R.id.listaAmici);
        String[] values = new String[] {};

       ArrayList<Amici> list = new ArrayList<>();

       AmiciAdapter adapter = new AmiciAdapter(getActivity(), list);
       // AdapterStorico adapter = new AdapterStorico(getActivity(), list);
        MyApiEndpointInterface profilo = amici.create(MyApiEndpointInterface.class);



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick (AdapterView<?> parent, final View view, int position, long id){
                Intent profilo = new Intent (FragmentAmici.this.getActivity(), Profilo.class);
                Object item = listview.getItemAtPosition(position);
                String amico = item.toString();
                profilo.putExtra("username", amico);
                startActivity(profilo);

            }

        });
        return rootView;
    }

}





