package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class GirisActivity extends AppCompatActivity {
    private Button buttonGiris;
    private EditText editText_KullaniciAdi, editText_KullaniciSifre;
    private TextView textView_Kaydol;
    private Veritabani veritabani;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String usernameInfo, passwordInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        //tanımlamalar
        sharedPreferences = getSharedPreferences("GirisBilgileri", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        usernameInfo = sharedPreferences.getString("username", "null");
        passwordInfo = sharedPreferences.getString("password", "null");


        if (sharedPreferences.getBoolean("login",false)) {
            Intent intent = new Intent(GirisActivity.this, MainActivity.class);
            intent.putExtra("username",usernameInfo);
            startActivity(intent);
            finish();
            Toast.makeText(getApplicationContext(), "Oturumunuz Başarıyla Açıldı !", Toast.LENGTH_SHORT).show();
        }

        //Burda sharedPreferencas üzerine kayıtlı login değerini alıyoruz.
        //Login değeri doğru giriş yapıldığında veya kayıt olduğunda true olarak kaydedilir
        //Amacı ise kullanıcı uygulamadan cıkarken direk çıkıs demeden cıktıysa yanı direk home veya back tusuyla uygulamadan çıktıysa
        //Geri geldiğinde tekrar giriş bilgilerini istemeden anasayfaya yönlendiriyoruz
        //Bu değer ancak anasayfa üzerinde cıkış butonuna basılırsa diğer bilgiler silinmeden bu değer false yapılır
        //ve uygulamaya tekrar girildiğinde kayıt olurken kullandığı şifre ve emaili ister
//        if(preferences.getBoolean("login", false)){
//            Intent i = new Intent(getApplicationContext(),Anasayfa.class);
//            startActivity(i);
//            finish();
//        }

        //idler
        buttonGiris = findViewById(R.id.buttonGiris);
        editText_KullaniciAdi = findViewById(R.id.editText_KullaniciAdi);
        editText_KullaniciSifre = findViewById(R.id.editText_KullaniciSifre);
        textView_Kaydol = findViewById(R.id.textView_Kaydol);

        //veritabanı kopyalama

        veritabaniKopyala();

        veritabani = new Veritabani(getApplicationContext());


        //click events
        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kullaniciAdi = editText_KullaniciAdi.getText().toString();
                String sifre = editText_KullaniciSifre.getText().toString();


                if (TextUtils.isEmpty(kullaniciAdi) || TextUtils.isEmpty(sifre)) {
                    Toast.makeText(getApplicationContext(), "Kullanıcı Adı / Şifre Giriniz !", Toast.LENGTH_SHORT).show();
                } else {

                    if (new GirisDao().girisKontrol(veritabani, kullaniciAdi, sifre) > 0) {
                        editor.putBoolean("login",true);
                        editor.putString("username", editText_KullaniciAdi.getText().toString());
                        editor.putString("password", editText_KullaniciSifre.getText().toString());
                        editor.commit();

                        Intent intent = new Intent(GirisActivity.this, MainActivity.class);
                        intent.putExtra("username", kullaniciAdi);
                        startActivity(intent);
                        finish();
                    } else {
                        editText_KullaniciAdi.setText("");
                        editText_KullaniciSifre.setText("");

                        Snackbar.make(v, "Böyle Bir Hesap Bulunamadı !", Snackbar.LENGTH_LONG).setAction("Kayıt Ol", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(GirisActivity.this, KaydolActivity.class);
                                startActivity(intent);
                            }
                        }).show();
                    }
                }


            }
        });

        textView_Kaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GirisActivity.this, KaydolActivity.class));
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //veritabanı kopyalama
    public void veritabaniKopyala() {
        DatabaseCopyHelper helper = new DatabaseCopyHelper(getApplicationContext());
        try {
            helper.createDataBase();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        helper.openDataBase();
    }
}