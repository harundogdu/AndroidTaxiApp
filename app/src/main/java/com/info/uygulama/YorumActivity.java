package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class YorumActivity extends AppCompatActivity {

    private ImageView imageViewYorum;
    private TextView textViewYorumIsim, textViewYorumMeslek, textViewYorumOylama, textViewYorumPlaka;
    private EditText editTextYorumYorum;
    private Button buttonYorum;
    private Veritabani veritabani;
    private Calisanlar calisanlar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yorum);

        imageViewYorum = findViewById(R.id.imageViewYorum);
        textViewYorumIsim = findViewById(R.id.textViewYorumIsim);
        textViewYorumMeslek = findViewById(R.id.textViewYorumMeslek);
        textViewYorumOylama = findViewById(R.id.textViewYorumOylama);
        textViewYorumPlaka = findViewById(R.id.textViewYorumPlaka);
        editTextYorumYorum = findViewById(R.id.editTextYorumYorum);
        buttonYorum = findViewById(R.id.buttonYorum);

        veritabani = new Veritabani(getApplicationContext());


        calisanlar = (Calisanlar) getIntent().getSerializableExtra("calisanlar");

        imageViewYorum.setImageResource(getResources().getIdentifier(calisanlar.getCalisan_resim(), "drawable", getPackageName()));
        textViewYorumIsim.setText("Sürücü İsmi : " + calisanlar.getCalisan_isim());
        textViewYorumMeslek.setText("Sürücü Meslek : " + calisanlar.getCalisan_meslek());
        textViewYorumPlaka.setText("Araç Plakası : " + calisanlar.getCalisan_plaka());
        textViewYorumOylama.setText("Sürücü Ortalaması : " + calisanlar.getCalisan_rating());

        buttonYorum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(editTextYorumYorum.getText().toString().trim())) {
                    Toast.makeText(getApplicationContext(), "Lütfen Yorumunuzu Giriniz !", Toast.LENGTH_LONG).show();
                } else {
                    new CalisanlarDao().YorumYap(veritabani,
                            calisanlar.getCalisan_id(),
                            editTextYorumYorum.getText().toString().trim(),
                            calisanlar.getCalisan_isim());
                    Toast.makeText(getApplicationContext(), "Yorumunuz Başarıyla Gönderildi !", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(YorumActivity.this,MainActivity.class));
                    finish();
                }

            }
        });

    }
}