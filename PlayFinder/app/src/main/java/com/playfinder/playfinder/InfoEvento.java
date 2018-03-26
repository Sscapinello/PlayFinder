package com.playfinder.playfinder;

        import android.app.Activity;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.google.android.gms.maps.MapView;

        import java.util.ArrayList;

public class InfoEvento extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_evento);

        TextView text1 = findViewById(R.id.textCalcio);
        text1.setText("Calcio a 7");
        TextView text2 = findViewById(R.id.textTeam1);
        TextView text3 = findViewById(R.id.textTeam2);
        ImageView img1 = findViewById(R.id.image1);
        ImageView img2 = findViewById(R.id.image2);
        MapView map = findViewById(R.id.mapView);

        final ArrayList<String> colonna1 = new ArrayList<String>();
        ArrayList<String> colonna2 = new ArrayList<String>();
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Uri intentUri = Uri.parse("geo:0.0?q=");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, intentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 1000);
            }
        });

        if (text1.toString().equals("Calcio a 7")) {
            for (int i = 0; i < 7; i++) {
                colonna1.add("Giocatore" + i++);
                colonna2.add("Giocatore" + i);
            }
        } else if (text1.toString().equals("calcio a 11")) {
            for (int i = 0; i < 11; i++) {
                colonna1.add("Giocatore" + i++);
                colonna2.add("Giocatore" + i);
            }
        } else if (text1.toString().equals("Calcio a 5")) {
            for (int i = 0; i < 5; i++) {
                colonna1.add("Giocatore" + i++);
                colonna2.add("Giocatore" + i);
            }
        }else if (text1.toString().equals("Basket")) {
            for (int i = 0; i > 5; i++) {
                colonna1.add("Giocatore" + i++);
                colonna2.add("Giocatore" + i++);
            }
        }else if(text1.toString().equals("Tennis")){
            colonna1.add("Giocatore");
            colonna2.add("Giocatore");
            ListView lista1 = findViewById(R.id.list1);
            ListAdapter adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, colonna1);
            lista1.setAdapter(adapter1);
            ListView lista2 = findViewById(R.id.list2);
            ListAdapter adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, colonna2);
            lista2.setAdapter(adapter2);


            lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selItem = (String) parent.getItemAtPosition(position);
                    if (selItem.contains("Giocatore")) {
                        colonna1.add(position, "Nuovo giocatore");

                        //String User =
                        //colonna1.add(position, User);
                    } else {
                        Intent p1 = new Intent(InfoEvento.this, Profilo.class);
                        startActivity(p1);

                    }
                }
            });


            lista2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selItem = (String) parent.getItemAtPosition(position);
                    if (selItem.contains("Calciatore")) {

                        //colonna2.add(position, User);

                    } else {
                        Intent p2 = new Intent(InfoEvento.this, Profilo.class);
                        startActivity(p2);
                    }
                }

            });

        }

    }
}