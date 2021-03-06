package com.example.kiek.airportapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Kiek on 14-3-2016.
 */
public class AirportsDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "airports.db";
    private static final int DATABASE_VERSION = 1;

    public AirportsDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Hier de CRUD methoden
    public Cursor getAirports() {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT icao, name FROM airports WHERE iso_country = \"NL\"";
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        db.close();
        return c;
    }

    public Cursor getAirportDetail(String icao) {
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM airports WHERE icao ='"+icao+"'";
        Cursor c2 = db.rawQuery(query, null);
        c2.moveToFirst();
        db.close();
        return c2;
    }

    public Cursor getSearchResult(String query) {
        SQLiteDatabase db = getReadableDatabase();

        String result = "SELECT icao, name FROM airports WHERE name LIKE '%"+query+"%'";
        Cursor c3 = db.rawQuery(result, null);
        c3.moveToFirst();
        db.close();
        return c3;

    }

}
