package com.info.uygulama;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CalisanlarDao {
    public ArrayList<Calisanlar> calisanVerileriGetir(Veritabani veritabani) {
        ArrayList<Calisanlar> calisanlarArrayList = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM calisanlar ORDER BY calisan_isim ASC", null);

        while (c.moveToNext()) {
            Calisanlar calisanlar = new Calisanlar(
                    c.getInt(c.getColumnIndex("calisan_id")),
                    c.getString(c.getColumnIndex("calisan_isim")),
                    c.getString(c.getColumnIndex("calisan_resim")),
                    c.getString(c.getColumnIndex("calisan_meslek")),
                    c.getString(c.getColumnIndex("calisan_plaka")),
                    Double.parseDouble(c.getString(c.getColumnIndex("calisan_rating"))),
                    c.getInt(c.getColumnIndex("calisan_durak_id")),
                    c.getInt(c.getColumnIndex("calisan_toplamOy"))
            );
            calisanlarArrayList.add(calisanlar);
        }

        return calisanlarArrayList;
    }

    public ArrayList<Calisanlar> calisanVerileriGetirByID(Veritabani veritabani, int duraklar_id) {
        ArrayList<Calisanlar> calisanlarArrayList = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM calisanlar INNER JOIN duraklar " +
                "ON calisanlar.calisan_durak_id = duraklar.duraklar_id WHERE duraklar.duraklar_id = " + duraklar_id, null);

        while (c.moveToNext()) {
            Calisanlar calisanlar = new Calisanlar(
                    c.getInt(c.getColumnIndex("calisan_id")),
                    c.getString(c.getColumnIndex("calisan_isim")),
                    c.getString(c.getColumnIndex("calisan_resim")),
                    c.getString(c.getColumnIndex("calisan_meslek")),
                    c.getString(c.getColumnIndex("calisan_plaka")),
                    Double.parseDouble(c.getString(c.getColumnIndex("calisan_rating"))),
                    c.getInt(c.getColumnIndex("calisan_durak_id")),
                    c.getInt(c.getColumnIndex("calisan_toplamOy"))
            );
            calisanlarArrayList.add(calisanlar);
        }

        return calisanlarArrayList;
    }

    public void OylamaSonucu(Veritabani veritabani, int calisan_id, double calisan_rating) {
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM calisanlar WHERE calisan_id =" + calisan_id, null);
        double oy = 0.0;
        int toplamOy = 0;
        double sonuc = 0.0;

        while (c.moveToNext()) {
            oy = Double.parseDouble(c.getString(c.getColumnIndex("calisan_rating")));
            toplamOy = c.getInt(c.getColumnIndex("calisan_toplamOy"));
        }

        if (toplamOy == 0) {
            toplamOy = 2;
        }

        sonuc =  ((calisan_rating + (oy * (toplamOy - 1))) / toplamOy);
        sonuc = Double.parseDouble(String.format(Locale.US, "%.2f", sonuc));


        Log.e("dalga1",String.valueOf(sonuc));

        ContentValues values = new ContentValues();
        values.put("calisan_rating",sonuc);
        values.put("calisan_toplamOy", (toplamOy + 1));

        database.update("calisanlar", values, "calisan_id=?", new String[]{String.valueOf(calisan_id)});

    }

    public void YorumYap(Veritabani veritabani, int calisan_id, String yorum, String calisan_isim) {
        SQLiteDatabase database = veritabani.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("yorumlar_icerik", yorum);
        values.put("yorumlar_yorumYapan", calisan_isim);
        values.put("yorumlar_calisan_id", calisan_id);

        database.insertOrThrow("yorumlar", null, values);
    }

}
