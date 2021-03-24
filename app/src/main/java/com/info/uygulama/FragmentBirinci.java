package com.info.uygulama;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class FragmentBirinci extends Fragment {
    private Toolbar toolbar_fragmentBir;
    private RecyclerView rv_fragmentBir;
    private ArrayList<Calisanlar> calisanlarArrayList;
    private CalisanlarAdapter adapter;
    private Veritabani veritabani;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_birinci, container, false);

        toolbar_fragmentBir = rootView.findViewById(R.id.toolbar_fragmentBir);
        rv_fragmentBir = rootView.findViewById(R.id.rv_fragmentBir);

        toolbar_fragmentBir.setTitle("Şoför Listesi");
        toolbar_fragmentBir.setTitleTextColor(Color.BLACK);

        // rv_fragmentBir.hasFixedSize(true);

        rv_fragmentBir.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        // rv_fragmentBir.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));

        // veritabanı
        veritabani = new Veritabani(getContext());

        calisanlarArrayList = new CalisanlarDao().calisanVerileriGetir(veritabani);

        adapter = new CalisanlarAdapter(rootView.getContext(), calisanlarArrayList);

        rv_fragmentBir.setAdapter(adapter);

        return rootView;
    }
}
