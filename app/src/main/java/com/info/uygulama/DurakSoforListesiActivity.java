package com.info.uygulama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;

public class DurakSoforListesiActivity extends AppCompatActivity {
    private Toolbar toolbar_durakSoforListesi;
    private RecyclerView rv_durakSoforListesi;
    private DurakSoforListesiAdapter adapter;
    private ArrayList<Calisanlar> calisanlarArrayList;
    private Veritabani veritabani;
    private Duraklar duraklar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_durak_sofor_listesi);

        toolbar_durakSoforListesi = findViewById(R.id.toolbar_durakSoforListesi);
        rv_durakSoforListesi = findViewById(R.id.rv_durakSoforListesi);

        toolbar_durakSoforListesi.setTitle("Durak Şoför Listesi");
        toolbar_durakSoforListesi.setTitleTextColor(Color.BLACK);

        rv_durakSoforListesi.setLayoutManager(new LinearLayoutManager(this));

        veritabani = new Veritabani(getApplicationContext());

        duraklar = (Duraklar) getIntent().getSerializableExtra("duraklar");

        calisanlarArrayList = new CalisanlarDao().calisanVerileriGetirByID(veritabani, duraklar.getDuraklar_id());

        adapter = new DurakSoforListesiAdapter(getApplicationContext(), calisanlarArrayList);

        rv_durakSoforListesi.setAdapter(adapter);


    }
}