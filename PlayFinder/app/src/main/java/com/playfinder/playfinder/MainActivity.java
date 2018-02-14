package com.playfinder.playfinder;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends Activity {

    private DBAdapter customAdapter;
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
        customAdapter = new DBAdapter(MainActivity.this, ());
        listView.setAdapter(customAdapter);


    }

}
