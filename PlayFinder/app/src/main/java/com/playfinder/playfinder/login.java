package com.playfinder.playfinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends Activity {

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
        setContentView(R.layout.activity_login);

        username = (TextView) findViewById(R.id.username);
        usernametext = (EditText) findViewById(R.id.usernameText);
        password = (TextView) findViewById(R.id.password);
        passwordText = (EditText) findViewById(R.id.passwordText);
        accedi = (Button) findViewById(R.id.accedi);
        account = (TextView) findViewById(R.id.account);
        registrati = (Button) findViewById(R.id.registrati);

        accedi.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(login.this, );
                startActivity(intent);
            }

        }
        );

}
}



