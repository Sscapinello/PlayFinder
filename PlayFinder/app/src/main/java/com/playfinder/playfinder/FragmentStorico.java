package com.playfinder.playfinder;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class FragmentStorico extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_fragment_storico, container, false);

        final ListView listview = rootView.findViewById(R.id.listaAmici);
        /*String[] values = new String[] {};

        ArrayList<String> list =new ArrayList<String>();
        for(int i=0; i<values.length; ++i){
            list.add(values[i]);
        }*/

        ArrayList<Partita> list =new ArrayList<>();


        AdapterStorico adapter = new AdapterStorico(getActivity(), list);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick (AdapterView<?> parent, final View view, int position, long id){
                Intent profilo = new Intent (FragmentStorico.this.getActivity(), InfoEvento.class);
                startActivity(profilo);

            }

        });
        return rootView;
    }

}