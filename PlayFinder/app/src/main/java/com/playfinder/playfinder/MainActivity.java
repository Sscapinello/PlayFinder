package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

 /*   private DBAdapter customAdapter;
    private dbHelper databaseHelper;
    private static final int ENTER_DATA_REQUEST_CODE = 1;
    private ListView listView;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper hlpr = new dbHelper(this);
        DBAdapter dbtr = new DBAdapter(this);

        listView = (ListView)findViewById(R.id.list_data);
        //customAdapter = new DBAdapter(MainActivity.this, ());
        //listView.setAdapter(customAdapter);


    }
*/


        TextView username;
        EditText usernametext;
        TextView password;
        EditText passwordText;
        Button accedi;
        TextView account;
        Button registrati;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

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
               public void onClick(View v) {
                   //   Intent intent = new Intent(com.playfinder.playfinder.MainActivity.this, Home.class);
                   // startActivity(intent);
               }

               }
            );

        }

    }


