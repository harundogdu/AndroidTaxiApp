package com.info.uygulama;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KaydolDao {

    public int kullaniciAdiAra(Veritabani veritabani, String kaydol_username) {
        ArrayList<String> kullanici = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM kaydol WHERE kaydol_username LIKE '%" + kaydol_username + "%'", null);

        while (c.moveToNext()) {
            kullanici.add(c.getString(c.getColumnIndex("kaydol_username")));
        }

        return kullanici.size();
    }

    public int kullaniciMailAra(Veritabani veritabani, String kaydol_eposta) {
        ArrayList<String> kullanici = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM kaydol WHERE kaydol_eposta LIKE '%" + kaydol_eposta + "%'", null);

        while (c.moveToNext()) {
            kullanici.add(c.getString(c.getColumnIndex("kaydol_eposta")));
        }

        return kullanici.size();
    }


    public void kisiKaydet(Veritabani veritabani, String kaydol_username, String kaydol_password, String kaydol_eposta) {
        SQLiteDatabase database = veritabani.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kaydol_username", kaydol_username);
        values.put("kaydol_password", kaydol_password);
        values.put("kaydol_eposta", kaydol_eposta);
        database.insertOrThrow("kaydol", null, values);
    }

}
