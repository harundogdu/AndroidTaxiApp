package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class KaydolActivity extends AppCompatActivity {
    private TextView textView_KaydolGiris;
    private Toolbar toolbar_kaydol;
    private EditText editTextKaydol_Sifre, editTextKaydol_SifreTekrar, editTextKaydol_Eposta, editTextKaydol_KullaniciAdi;
    private Button buttonKaydol;
    private String kullaniciAdi, sifre, sifreTekrar, eposta;
    private Veritabani veritabani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);
        //idler
        textView_KaydolGiris = findViewById(R.id.textView_KaydolGiris);
        toolbar_kaydol = findViewById(R.id.toolbar_kaydol);
        editTextKaydol_Sifre = findViewById(R.id.editTextKaydol_Sifre);
        editTextKaydol_SifreTekrar = findViewById(R.id.editTextKaydol_SifreTekrar);
        editTextKaydol_Eposta = findViewById(R.id.editTextKaydol_Eposta);
        editTextKaydol_KullaniciAdi = findViewById(R.id.editTextKaydol_KullaniciAdi);
        buttonKaydol = findViewById(R.id.buttonKaydol);


        //toolbar Ayarları
        toolbar_kaydol.setTitle("Kayıt Ol !");
        toolbar_kaydol.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar_kaydol);

        //veritabanı Ayarları

        veritabani = new Veritabani(this);

        //click eventleri

        textView_KaydolGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KaydolActivity.this, GirisActivity.class));
                finish();
            }
        });

        buttonKaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tanımlamalar

                kullaniciAdi = editTextKaydol_KullaniciAdi.getText().toString();
                sifre = editTextKaydol_Sifre.getText().toString();
                sifreTekrar = editTextKaydol_SifreTekrar.getText().toString();
                eposta = editTextKaydol_Eposta.getText().toString();


                if(TextUtils.isEmpty(kullaniciAdi) || TextUtils.isEmpty(sifre) || TextUtils.isEmpty(sifreTekrar) || TextUtils.isEmpty(eposta)){
                    Toast.makeText(getApplicationContext(), "Boş Alanları Doldurunuz !", Toast.LENGTH_SHORT).show();
                    return;
                }else{

                    if (new KaydolDao().kullaniciMailAra(veritabani, eposta) != 0) {
                        Toast.makeText(getApplicationContext(), "E-Posta Zaten Var !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!sifre.equals(sifreTekrar)) {
                        Toast.makeText(getApplicationContext(), "Sifreler Uyuşmuyor !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (new KaydolDao().kullaniciAdiAra(veritabani, kullaniciAdi) != 0) {
                        Toast.makeText(getApplicationContext(), "Kullanıcı Adı Zaten Var !", Toast.LENGTH_SHORT).show();
                        return;
                    }

                }



                // Kullanıcı Kayıt İşlemleri

                new KaydolDao().kisiKaydet(veritabani, kullaniciAdi, sifre, eposta);
                Snackbar.make(v, "Başarıla Kayıt Oldunuz !", Snackbar.LENGTH_LONG).setAction("Giriş Yap", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(KaydolActivity.this, GirisActivity.class);
                        intent.putExtra("kullaniciAdi", kullaniciAdi);
                        startActivity(intent);
                        finish();
                    }
                }).show();
            }
        });
    }
}