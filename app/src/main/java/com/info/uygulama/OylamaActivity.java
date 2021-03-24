package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class OylamaActivity extends AppCompatActivity {
    private ImageView imageViewKisi;
    private TextView textViewIsimKisi, textViewMeslekKisi, textViewOylamaKisi, textViewPlakaKisi;
    private Button buttonKaydetKisi;
    private RatingBar ratingBarKisi;
    private Veritabani veritabani;


    private Calisanlar calisanlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oylama);

        imageViewKisi = findViewById(R.id.imageViewKisi);
        textViewIsimKisi = findViewById(R.id.textViewIsimKisi);
        textViewMeslekKisi = findViewById(R.id.textViewMeslekKisi);
        textViewOylamaKisi = findViewById(R.id.textViewOylamaKisi);
        textViewPlakaKisi = findViewById(R.id.textViewPlakaKisi);
        buttonKaydetKisi = findViewById(R.id.buttonKaydetKisi);
        ratingBarKisi = findViewById(R.id.ratingBarKisi);

        veritabani = new Veritabani(getApplicationContext());


        calisanlar = (Calisanlar) getIntent().getSerializableExtra("calisanlar");

        imageViewKisi.setImageResource(getResources().getIdentifier(calisanlar.getCalisan_resim(), "drawable", getPackageName()));
        textViewIsimKisi.setText("Sürücü İsmi : " + calisanlar.getCalisan_isim());
        textViewMeslekKisi.setText("Sürücü Meslek : " + calisanlar.getCalisan_meslek());
        textViewPlakaKisi.setText("Araç Plakası : " + calisanlar.getCalisan_plaka());
        textViewOylamaKisi.setText("Sürücü Ortalaması : " + calisanlar.getCalisan_rating());


        buttonKaydetKisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ratingBarKisi.getRating() != 0) {

                    new CalisanlarDao().OylamaSonucu(veritabani,calisanlar.getCalisan_id(),ratingBarKisi.getRating());
                    new DuraklarDao().durakPuaniGuncelle(veritabani,calisanlar.getCalisan_durak_id());
                    startActivity(new Intent(OylamaActivity.this,MainActivity.class));
                    finish();

                } else {
                    Toast.makeText(getApplicationContext(), "Lütfen Oyunuzu Giriniz !", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}