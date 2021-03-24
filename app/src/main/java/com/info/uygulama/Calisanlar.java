package com.info.uygulama;

import android.content.Context;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class Calisanlar implements Serializable {
    private int calisan_id;
    private String calisan_isim, calisan_resim , calisan_meslek ,calisan_plaka;
    private double calisan_rating;
    private int calisan_durak_id;
    private int calisan_toplamOy;

    public Calisanlar() {
    }



    public Calisanlar(int calisan_id, String calisan_isim, String calisan_resim, String calisan_meslek, String calisan_plaka, double calisan_rating, int calisan_durak_id, int calisan_toplamOy) {
        this.calisan_id = calisan_id;
        this.calisan_isim = calisan_isim;
        this.calisan_resim = calisan_resim;
        this.calisan_meslek = calisan_meslek;
        this.calisan_plaka = calisan_plaka;
        this.calisan_rating = calisan_rating;
        this.calisan_durak_id = calisan_durak_id;
        this.calisan_toplamOy = calisan_toplamOy;
    }

    public int getCalisan_durak_id() {
        return calisan_durak_id;
    }

    public void setCalisan_durak_id(int calisan_durak_id) {
        this.calisan_durak_id = calisan_durak_id;
    }

    public int getCalisan_toplamOy() {
        return calisan_toplamOy;
    }

    public void setCalisan_toplamOy(int calisan_toplamOy) {
        this.calisan_toplamOy = calisan_toplamOy;
    }

    public int getCalisan_id() {
        return calisan_id;
    }

    public void setCalisan_id(int calisan_id) {
        this.calisan_id = calisan_id;
    }

    public String getCalisan_isim() {
        return calisan_isim;
    }

    public void setCalisan_isim(String calisan_isim) {
        this.calisan_isim = calisan_isim;
    }

    public String getCalisan_resim() {
        return calisan_resim;
    }

    public void setCalisan_resim(String calisan_resim) {
        this.calisan_resim = calisan_resim;
    }

    public String getCalisan_meslek() {
        return calisan_meslek;
    }

    public void setCalisan_meslek(String calisan_meslek) {
        this.calisan_meslek = calisan_meslek;
    }

    public String getCalisan_plaka() {
        return calisan_plaka;
    }

    public void setCalisan_plaka(String calisan_plaka) {
        this.calisan_plaka = calisan_plaka;
    }

    public double getCalisan_rating() {
        return calisan_rating;
    }

    public void setCalisan_rating(double calisan_rating) {
        this.calisan_rating = calisan_rating;
    }
}

