package com.playfinder.playfinder;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AdapterStorico extends ArrayAdapter<Partita> {

    private final Context context;
    private final ArrayList<Partita> values;

    TextView s1;
    TextView s2;
    TextView rs1;
    TextView rs2;
    TextView nCampo;
    public AdapterStorico(Context context, ArrayList<Partita> values) {
        super(context, R.layout.activity_adapter_storico, values);

        this.context = context;
        this.values = values;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_adapter_storico, parent, false);

        s1 = (TextView) rowView.findViewById(R.id.s1);
        s2 = (TextView) rowView.findViewById(R.id.s2);
        rs1 = (TextView) rowView.findViewById(R.id.rS1);
        rs2 = (TextView) rowView.findViewById(R.id.rS2);
        nCampo = (TextView) rowView.findViewById(R.id.nField);

        s1.setText(values.get(position).getSquadraCasa().getNome());//position, posizione nell'array
        s2.setText(values.get(position).getSquadraTrasferta().getNome());
        rs1.setText(values.get(position).getrCasa());
        rs2.setText(values.get(position).getrTrasferta());
        nCampo.setText(values.get(position).getCampo().getVia());

        return rowView;
    }
}