package com.info.uygulama;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class YorumlarDao {
    public ArrayList<Yorumlar> tumYorumlariGetir(Veritabani veritabani) {
        ArrayList<Yorumlar> yorumlarArrayList = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM yorumlar " +
                "INNER JOIN calisanlar ON yorumlar.yorumlar_calisan_id = calisanlar.calisan_id " +
                "ORDER BY yorumlar.yorumlar_id DESC", null);

        while (c.moveToNext()) {
            Yorumlar yorumlar = new Yorumlar(
                    c.getInt(c.getColumnIndex("yorumlar_id")),
                    c.getString(c.getColumnIndex("yorumlar_icerik")),
                    c.getString(c.getColumnIndex("calisan_isim")),
                    c.getDouble(c.getColumnIndex("calisan_rating")),
                    c.getString(c.getColumnIndex("calisan_plaka")),
                    c.getString(c.getColumnIndex("calisan_resim"))
            );

            yorumlarArrayList.add(yorumlar);
        }

        return yorumlarArrayList;
    }
}
