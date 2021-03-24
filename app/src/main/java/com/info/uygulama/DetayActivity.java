package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivity extends AppCompatActivity {
    private Toolbar toolbar_detay;
    private ImageView imageViewDetay_SoforResim;
    private TextView textViewDetay_SoforIsım, textViewDetay_SoforMeslek, textViewDetay_SoforPuan, textViewDetay_SoforPlaka;
    private Calisanlar calisanlar;
    private Yorumlar yorumlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        toolbar_detay = findViewById(R.id.toolbar_detay);
        imageViewDetay_SoforResim = findViewById(R.id.imageViewDetay_SoforResim);
        textViewDetay_SoforMeslek = findViewById(R.id.textViewDetay_SoforMeslek);
        textViewDetay_SoforPuan = findViewById(R.id.textViewDetay_SoforPuan);
        textViewDetay_SoforPlaka = findViewById(R.id.textViewDetay_SoforPlaka);
        textViewDetay_SoforIsım = findViewById(R.id.textViewDetay_SoforIsım);

        toolbar_detay.setTitle("Şoför Detayı");
        toolbar_detay.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar_detay);

        calisanlar = (Calisanlar) getIntent().getSerializableExtra("calisanlar");

        imageViewDetay_SoforResim.setImageResource(getResources().getIdentifier(calisanlar.getCalisan_resim(), "drawable", getPackageName()));
        textViewDetay_SoforIsım.setText(calisanlar.getCalisan_isim());
        textViewDetay_SoforMeslek.setText(calisanlar.getCalisan_meslek());
        textViewDetay_SoforPlaka.setText(calisanlar.getCalisan_plaka());
        textViewDetay_SoforPuan.setText(String.valueOf(calisanlar.getCalisan_rating()));

    }
}