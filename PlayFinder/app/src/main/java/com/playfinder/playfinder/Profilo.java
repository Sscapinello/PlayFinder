package com.playfinder.playfinder;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Profilo extends AppCompatActivity {

   private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    FragmentProfilo profilo = new FragmentProfilo();
                    FragmentTransaction fragmentTransactionP = getFragmentManager().beginTransaction();
                    fragmentTransactionP.replace(R.id.navigation, profilo, "");
                    fragmentTransactionP.commit();
                    return true;

                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    FragmentStorico src = new FragmentStorico();

                    FragmentTransaction fragmentTransactionS = getFragmentManager().beginTransaction();
                    fragmentTransactionS.replace(R.id.navigation, src,"");
                    fragmentTransactionS.commit();
                    return true;

                case R.id.navigation_notifications:
                    FragmentAmici fgmt = new FragmentAmici();

                    FragmentTransaction fragmentTransactionA = getFragmentManager().beginTransaction();
                    fragmentTransactionA.replace(R.id.navigation, fgmt,"");
                    fragmentTransactionA.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);
        String u = getIntent().getExtras().getString("username");

        TextView nomeProfilo = findViewById(R.id.nomeProfilo);
        nomeProfilo.setText(u);
        setContentView(R.layout.activity_profilo);
        FragmentProfilo profilo = new FragmentProfilo();
        FragmentTransaction fragmentTransactionP = getFragmentManager().beginTransaction();
        fragmentTransactionP.replace(R.id.navigation, profilo, "");
        fragmentTransactionP.commit();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

}
