package com.info.uygulama;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class GirisDao {
    public int girisKontrol(Veritabani veritabani, String kaydol_username, String kaydol_password) {
        ArrayList<String> kulllani = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM kaydol WHERE kaydol_username ='" + kaydol_username +
                        "' AND kaydol_password ='" + kaydol_password + "'",
                null);

        while (c.moveToNext()) {
            kulllani.add(c.getString(c.getColumnIndex("kaydol_username")));
        }

        return kulllani.size();
    }
}
