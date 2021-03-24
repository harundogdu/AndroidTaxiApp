package com.info.uygulama;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentIkinci extends Fragment {
    private Toolbar toolbar_yorumlar;
    private RecyclerView rv_yorumlar;
    private Veritabani veritabani;
    private ArrayList<Yorumlar> yorumlarArrayList;
    private YorumlarAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ikinci, container, false);

        toolbar_yorumlar = rootView.findViewById(R.id.toolbar_yorumlar);
        rv_yorumlar = rootView.findViewById(R.id.rv_yorumlar);

        toolbar_yorumlar.setTitle("Yorumlar Sayfası");
        toolbar_yorumlar.setTitleTextColor(Color.BLACK);

        rv_yorumlar.setHasFixedSize(true);
        rv_yorumlar.setLayoutManager(new LinearLayoutManager(getContext()));

        veritabani = new Veritabani(getContext());

        yorumlarArrayList = new YorumlarDao().tumYorumlariGetir(veritabani);

        adapter = new YorumlarAdapter(getContext(), yorumlarArrayList);

        rv_yorumlar.setAdapter(adapter);

        return rootView;


    }
}
