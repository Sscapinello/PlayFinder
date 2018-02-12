package com.playfinder.playfinder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class DBAdapter {
    @SuppressWarnings("unused")
    private static final String LOG_TAG = DBAdapter.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private dbHelper dbHelper;

    // Database fields
    private static final String DATABASE_TABLE = "user";

    public static final String KEY_NAME = "name";
    public static final String KEY_SURNAME = "surname";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_CITTA = "citta";
    public static final String KEY_ETA = "eta";
    public static final String KEY_REGIONE = "regione";
    public static final String KEY_TELEFONO = "telefono";
    public static final String KEY_RUOLO = "ruolo_partita";


    public DBAdapter(Context context) {
        this.context = context;
    }

    public DBAdapter open() throws SQLException {
        dbHelper = new dbHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {

        dbHelper.close();
    }
    public Cursor getAllData () {
        String buildSQL = "SELECT * FROM " + DATABASE_TABLE;
        Log.d(TAG, "getAllData SQL:" +buildSQL);
        return database.rawQuery(buildSQL, null);
    }
    public void insertData (String name, String surname, String username, String email, String password, String città
    , String età, String regione, String telefono, String ruolo){
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_NAME, name);
        contentValues.put(KEY_SURNAME, surname);
        contentValues.put(KEY_USERNAME, username);
        contentValues.put(KEY_EMAIL, email);
        contentValues.put(KEY_PASSWORD, password);
        contentValues.put(KEY_CITTA, città);
        contentValues.put(KEY_ETA, età);
        contentValues.put(KEY_REGIONE, regione);
        contentValues.put(KEY_TELEFONO, telefono);

    }
}