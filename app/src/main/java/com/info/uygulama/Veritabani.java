package com.info.uygulama;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {
    public Veritabani(@Nullable Context context) {
        super(context, "taksison.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS kaydol (" +
                "kaydol_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "kaydol_username TEXT," +
                "kaydol_password TEXT," +
                "kaydol_eposta TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS calisanlar (" +
                "calisan_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "calisan_isim TEXT," +
                "calisan_meslek TEXT," +
                "calisan_plaka TEXT," +
                "calisan_resim TEXT," +
                "calisan_toplamOy INTEGER," +
                "calisan_puan TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS duraklar (" +
                "duraklar_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "duraklar_isim TEXT," +
                "duraklar_lokasyon TEXT," +
                "duraklar_resim TEXT," +
                "duraklar_meslek TEXT," +
                "duraklar_ortalama TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS yorumlar (" +
                "yorumlar_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "yorumlar_icerik TEXT," +
                "yorumlar_yorumYapan TEXT," +
                "yorumlar_calisan_id INTEGER)");

        db.execSQL("CREATE TABLE IF NOT EXISTS kullanici (" +
                "kullanici_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "kullaniciAdi TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kaydol");
        db.execSQL("DROP TABLE IF EXISTS calisanlar");
        db.execSQL("DROP TABLE IF EXISTS duraklar");
        db.execSQL("DROP TABLE IF EXISTS yorumlar");
        db.execSQL("DROP TABLE IF EXISTS kullanici");
        onCreate(db);
    }
}
