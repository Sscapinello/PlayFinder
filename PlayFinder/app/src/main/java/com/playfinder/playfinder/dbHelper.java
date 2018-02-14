package com.playfinder.playfinder;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class dbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "playfinder.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table contact (_id integer primary key autoincrement, name text " +
            "not null, surname text not null, birth_date text not null);";

    public dbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);

    }
    public void onUpgrade( SQLiteDatabase database, int oldVersion, int newVersion) {

        database.execSQL(("DROP TABLE IF EXISTS contact "));
        onCreate(database);
    }

}