package com.exploreca.tourfinder.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by youshengchang on 3/20/2015.
 */
public class ToursDataSource {
    private static final String LOGTAG = "EXPLORECA";
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase database;

    public ToursDataSource(Context context) {
        dbHelper = new ToursDBOpenHelper(context);

    }

    public void open(){
        Log.i(LOGTAG, "datasource is opened");
        database = dbHelper.getWritableDatabase();
    }

    public void close(){
        Log.i(LOGTAG, "datasource is closed");
        dbHelper.close();
    }
}
