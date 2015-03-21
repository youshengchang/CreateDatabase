package com.exploreca.tourfinder.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.exploreca.tourfinder.model.Tour;

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

    public Tour create(Tour tour){

        ContentValues values = new ContentValues();
        values.put(ToursDBOpenHelper.COLUMN_TITLE, tour.getTitle());
        values.put(ToursDBOpenHelper.COLUMN_DESC, tour.getDescription());
        values.put(ToursDBOpenHelper.COLUMN_PRICE, tour.getPrice());
        values.put(ToursDBOpenHelper.COLUMN_IMAGE, tour.getImage());
        long insertId = database.insert(ToursDBOpenHelper.TABLE_TOURS, null, values);
        tour.setId(insertId);
        return tour;

    }
}
