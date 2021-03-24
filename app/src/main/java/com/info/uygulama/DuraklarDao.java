package com.info.uygulama;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

public class DuraklarDao {
    public ArrayList<Duraklar> durakVerileriGetir(Veritabani veritabani) {
        ArrayList<Duraklar> duraklarArrayList = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM duraklar ", null);

        while (c.moveToNext()) {
            Duraklar duraklar = new Duraklar(
                    c.getInt(c.getColumnIndex("duraklar_id")),
                    c.getString(c.getColumnIndex("duraklar_isim")),
                    c.getString(c.getColumnIndex("duraklar_lokasyon")),
                    c.getString(c.getColumnIndex("duraklar_resim")),
                    c.getString(c.getColumnIndex("duraklar_meslek")),
                    Double.parseDouble(c.getString(c.getColumnIndex("duraklar_ortalama")))
            );
            duraklarArrayList.add(duraklar);
        }

        return duraklarArrayList;
    }

    public void durakPuaniGuncelle(Veritabani veritabani, int calisan_durak_id) {
        SQLiteDatabase database = veritabani.getWritableDatabase();

        Cursor c = database.rawQuery("SELECT * FROM calisanlar INNER JOIN duraklar ON duraklar.duraklar_id = calisanlar.calisan_durak_id WHERE calisanlar.calisan_durak_id = " + calisan_durak_id,
                null);

        double ortalama = 0.0;
        double toplam = 0.0;

        while (c.moveToNext()) {
            toplam += Double.parseDouble(c.getString(c.getColumnIndex("calisan_rating")));
        }

        ortalama = toplam / 4.0;
        ortalama = Double.parseDouble(String.format(Locale.US, "%.2f", ortalama));
        Log.e("dalga2", String.valueOf(ortalama));

        ContentValues values = new ContentValues();
        values.put("duraklar_ortalama", ortalama);
        database.update("duraklar", values, "duraklar_id=?", new String[]{String.valueOf(calisan_durak_id)});

    }
}
