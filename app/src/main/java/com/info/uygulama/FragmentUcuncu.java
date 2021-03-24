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

public class FragmentUcuncu extends Fragment {
    private Toolbar toolbar_fragmentUc;
    private RecyclerView rv_fragmentUc;
    private ArrayList<Duraklar> duraklarArrayList;
    private Veritabani veritabani;
    private DuraklarAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_ucuncu, container, false);

        toolbar_fragmentUc = rootView.findViewById(R.id.toolbar_fragmentUc);
        rv_fragmentUc = rootView.findViewById(R.id.rv_fragmentUc);

        toolbar_fragmentUc.setTitle("Durak Listesi");
        toolbar_fragmentUc.setTitleTextColor(Color.BLACK);

        rv_fragmentUc.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        veritabani = new Veritabani(getContext());

        duraklarArrayList = new DuraklarDao().durakVerileriGetir(veritabani);

        adapter = new DuraklarAdapter(rootView.getContext(), duraklarArrayList);
//
        rv_fragmentUc.setAdapter(adapter);

        return rootView;


    }
}
