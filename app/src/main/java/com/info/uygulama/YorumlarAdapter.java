package com.info.uygulama;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YorumlarAdapter extends RecyclerView.Adapter<YorumlarAdapter.CardViewTutucuYorumlar> {
    private Context mContext;
    private ArrayList<Yorumlar> yorumlarArrayList;

    public YorumlarAdapter(Context mContext, ArrayList<Yorumlar> yorumlarArrayList) {
        this.mContext = mContext;
        this.yorumlarArrayList = yorumlarArrayList;
    }

    @NonNull
    @Override
    public CardViewTutucuYorumlar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yorumlar_tasarim, parent, false);
        return new CardViewTutucuYorumlar(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTutucuYorumlar holder, int position) {
        Yorumlar yorumlar = yorumlarArrayList.get(position);

        holder.imageViewYorumlar.setImageResource(mContext.getResources().getIdentifier(yorumlar.getYorumlar_resim(),"drawable",mContext.getPackageName()));
        holder.textView_YorumlarIsim.setText("Sürücü İsmi : " + yorumlar.getYorumlar_yorumYapan());
        holder.textView_YorumlarOrtalama.setText("Ortalama : " + yorumlar.getYorumlar_calisan_ortalama());
        holder.textView_YorumlarPlaka.setText("Araç Plakası : " + yorumlar.getYorumlar_yorumPlaka());
        holder.textView_YorumlarYorum.setText(yorumlar.getYorumlar_icerik());
        holder.cardViewYorumlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public int getItemCount() {
        return yorumlarArrayList.size();
    }

    public class CardViewTutucuYorumlar extends RecyclerView.ViewHolder {
        protected CardView cardViewYorumlar;
        protected ImageView imageViewYorumlar;
        protected TextView textView_YorumlarIsim, textView_YorumlarOrtalama, textView_YorumlarPlaka, textView_YorumlarYorum;

        public CardViewTutucuYorumlar(@NonNull View itemView) {
            super(itemView);
            cardViewYorumlar = itemView.findViewById(R.id.cardViewYorumlar);
            imageViewYorumlar = itemView.findViewById(R.id.imageViewYorumlar);
            textView_YorumlarIsim = itemView.findViewById(R.id.textView_YorumlarIsim);
            textView_YorumlarOrtalama = itemView.findViewById(R.id.textView_YorumlarOrtalama);
            textView_YorumlarPlaka = itemView.findViewById(R.id.textView_YorumlarPlaka);
            textView_YorumlarYorum = itemView.findViewById(R.id.textView_YorumlarYorum);
        }
    }
}
