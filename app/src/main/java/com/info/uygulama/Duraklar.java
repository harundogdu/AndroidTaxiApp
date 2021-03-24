package com.info.uygulama;

import java.io.Serializable;

public class Duraklar implements Serializable {
    private int duraklar_id;
    private String duraklar_isim, duraklar_lokasyon, duraklar_resim, duraklar_meslek;
    private double duraklar_ortalama;

    public Duraklar() {
    }

    public Duraklar(int duraklar_id, String duraklar_isim, String duraklar_lokasyon, String duraklar_resim, String duraklar_meslek, double duraklar_ortalama) {
        this.duraklar_id = duraklar_id;
        this.duraklar_isim = duraklar_isim;
        this.duraklar_lokasyon = duraklar_lokasyon;
        this.duraklar_resim = duraklar_resim;
        this.duraklar_meslek = duraklar_meslek;
        this.duraklar_ortalama = duraklar_ortalama;
    }

    public double getDuraklar_ortalama() {
        return duraklar_ortalama;
    }

    public void setDuraklar_ortalama(double duraklar_ortalama) {
        this.duraklar_ortalama = duraklar_ortalama;
    }

    public int getDuraklar_id() {
        return duraklar_id;
    }

    public void setDuraklar_id(int duraklar_id) {
        this.duraklar_id = duraklar_id;
    }

    public String getDuraklar_isim() {
        return duraklar_isim;
    }

    public void setDuraklar_isim(String duraklar_isim) {
        this.duraklar_isim = duraklar_isim;
    }

    public String getDuraklar_lokasyon() {
        return duraklar_lokasyon;
    }

    public void setDuraklar_lokasyon(String duraklar_lokasyon) {
        this.duraklar_lokasyon = duraklar_lokasyon;
    }

    public String getDuraklar_resim() {
        return duraklar_resim;
    }

    public void setDuraklar_resim(String duraklar_resim) {
        this.duraklar_resim = duraklar_resim;
    }

    public String getDuraklar_meslek() {
        return duraklar_meslek;
    }

    public void setDuraklar_meslek(String duraklar_meslek) {
        this.duraklar_meslek = duraklar_meslek;
    }
}
