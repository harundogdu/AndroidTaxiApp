package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetayActivityDuraklar extends AppCompatActivity {
    private Toolbar toolbar_detayDurak;
    private ImageView imageViewDetay_DurakResim;
    private TextView textViewDetay_DurakIsım, textViewDetay_DurakMeslek, textViewDetay_DurakPuan, textViewDetay_DurakLokasyon;
    private Duraklar duraklar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay_duraklar);

        toolbar_detayDurak = findViewById(R.id.toolbar_detayDurak);
        imageViewDetay_DurakResim = findViewById(R.id.imageViewDetay_DurakResim);
        textViewDetay_DurakIsım = findViewById(R.id.textViewDetay_DurakIsım);
        textViewDetay_DurakMeslek = findViewById(R.id.textViewDetay_DurakMeslek);
        textViewDetay_DurakPuan = findViewById(R.id.textViewDetay_DurakPuan);
        textViewDetay_DurakLokasyon = findViewById(R.id.textViewDetay_DurakLokasyon);


        toolbar_detayDurak.setTitle("Durak Detayı");
        toolbar_detayDurak.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar_detayDurak);

        duraklar = (Duraklar) getIntent().getSerializableExtra("duraklar");

        imageViewDetay_DurakResim.setImageResource(getResources().getIdentifier(duraklar.getDuraklar_resim(),"drawable",getPackageName()));
        textViewDetay_DurakIsım.setText(duraklar.getDuraklar_isim());
        textViewDetay_DurakMeslek.setText(duraklar.getDuraklar_meslek());
        textViewDetay_DurakLokasyon.setText(duraklar.getDuraklar_lokasyon());
        textViewDetay_DurakPuan.setText(String.valueOf(duraklar.getDuraklar_ortalama()));
    }
}