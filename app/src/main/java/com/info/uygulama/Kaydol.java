package com.info.uygulama;

public class Kaydol {
    private int kaydol_id;
    private String kaydol_username , kaydol_password , kaydol_eposta;

    public Kaydol() {
    }

    public Kaydol(int kaydol_id, String kaydol_username, String kaydol_password, String kaydol_eposta) {
        this.kaydol_id = kaydol_id;
        this.kaydol_username = kaydol_username;
        this.kaydol_password = kaydol_password;
        this.kaydol_eposta = kaydol_eposta;
    }

    public int getKaydol_id() {
        return kaydol_id;
    }

    public void setKaydol_id(int kaydol_id) {
        this.kaydol_id = kaydol_id;
    }

    public String getKaydol_username() {
        return kaydol_username;
    }

    public void setKaydol_username(String kaydol_username) {
        this.kaydol_username = kaydol_username;
    }

    public String getKaydol_password() {
        return kaydol_password;
    }

    public void setKaydol_password(String kaydol_password) {
        this.kaydol_password = kaydol_password;
    }

    public String getKaydol_eposta() {
        return kaydol_eposta;
    }

    public void setKaydol_eposta(String kaydol_eposta) {
        this.kaydol_eposta = kaydol_eposta;
    }
}
