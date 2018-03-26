package com.playfinder.playfinder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.*;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentProfilo extends Fragment {

    Retrofit amici = new Retrofit.Builder()
            .baseUrl("http://192.168.0.95:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TextView data;
    TextView nGiocati;
    TextView pe;
    TextView nCell;
    TextView textData;
    TextView textGiocati;
    TextView textVittorie;
    TextView textNome;
    TextView textCell;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);

         data = view.findViewById(R.id.data);
         nGiocati = view.findViewById(R.id.nGiocati);
         pe = view.findViewById(R.id.pe);
         nCell = view.findViewById(R.id.nCell);
         textData = view.findViewById(R.id.textData);
         textGiocati = view.findViewById(R.id.textGiocati);
         textVittorie = view.findViewById(R.id.textVittorie);
         textNome = view.findViewById(R.id.textNome);
         textCell = view.findViewById(R.id.textCell);


         data.setText("17/03/1997");
         nGiocati.setText("15");
         pe.setText("40%");
         nCell.setText("325648864564");

        return view;
    }

}






