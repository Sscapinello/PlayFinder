package com.playfinder.playfinder;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AmiciAdapter extends ArrayAdapter<Amici> {

    private final Context context;
    private final ArrayList<Amici> values;

    public AmiciAdapter(Context context, ArrayList<Amici> values) {
        super(context, R.layout.activity_amici_adapter, values);

        this.context = context;
        this.values = values;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_amici_adapter, parent, false);
        ImageView profilo = rowView.findViewById(R.id.profilePic);
        TextView nome = rowView.findViewById(R.id.amicoNome);
        TextView cognome = rowView.findViewById(R.id.amicoUsername);

        profilo.setImageResource(values.get(position).getProfilo());
        nome.setText(values.get(position).getNome());
        cognome.setText(values.get(position).getUsername());

        return rowView;
    }
}
