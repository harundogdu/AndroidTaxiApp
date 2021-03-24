package com.info.uygulama;

import java.io.Serializable;

public class Yorumlar implements Serializable {
    private int yorumlar_id;
    private String yorumlar_icerik , yorumlar_yorumYapan;
    private double yorumlar_calisan_ortalama;
    private String yorumlar_yorumPlaka;
    private String yorumlar_resim;

    public Yorumlar() {
    }

    public Yorumlar(int yorumlar_id, String yorumlar_icerik, String yorumlar_yorumYapan, double yorumlar_calisan_ortalama, String yorumlar_yorumPlaka, String yorumlar_resim) {
        this.yorumlar_id = yorumlar_id;
        this.yorumlar_icerik = yorumlar_icerik;
        this.yorumlar_yorumYapan = yorumlar_yorumYapan;
        this.yorumlar_calisan_ortalama = yorumlar_calisan_ortalama;
        this.yorumlar_yorumPlaka = yorumlar_yorumPlaka;
        this.yorumlar_resim = yorumlar_resim;
    }

    public String getYorumlar_resim() {
        return yorumlar_resim;
    }

    public void setYorumlar_resim(String yorumlar_resim) {
        this.yorumlar_resim = yorumlar_resim;
    }

    public double getYorumlar_calisan_ortalama() {
        return yorumlar_calisan_ortalama;
    }

    public void setYorumlar_calisan_ortalama(double yorumlar_calisan_ortalama) {
        this.yorumlar_calisan_ortalama = yorumlar_calisan_ortalama;
    }

    public String getYorumlar_yorumPlaka() {
        return yorumlar_yorumPlaka;
    }

    public void setYorumlar_yorumPlaka(String yorumlar_yorumPlaka) {
        this.yorumlar_yorumPlaka = yorumlar_yorumPlaka;
    }

    public int getYorumlar_id() {
        return yorumlar_id;
    }

    public void setYorumlar_id(int yorumlar_id) {
        this.yorumlar_id = yorumlar_id;
    }

    public String getYorumlar_icerik() {
        return yorumlar_icerik;
    }

    public void setYorumlar_icerik(String yorumlar_icerik) {
        this.yorumlar_icerik = yorumlar_icerik;
    }

    public String getYorumlar_yorumYapan() {
        return yorumlar_yorumYapan;
    }

    public void setYorumlar_yorumYapan(String yorumlar_yorumYapan) {
        this.yorumlar_yorumYapan = yorumlar_yorumYapan;
    }


}
