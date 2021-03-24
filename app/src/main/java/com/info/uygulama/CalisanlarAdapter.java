package com.info.uygulama;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CalisanlarAdapter extends RecyclerView.Adapter<CalisanlarAdapter.CardViewTutucu> {
    private Context mContext;
    private ArrayList<Calisanlar> calisanlarArrayList;

    public CalisanlarAdapter(Context mContext, ArrayList<Calisanlar> calisanlarArrayList) {
        this.mContext = mContext;
        this.calisanlarArrayList = calisanlarArrayList;
    }

    @NonNull
    @Override
    public CardViewTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new CardViewTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTutucu holder, int position) {
        Calisanlar calisanlar = calisanlarArrayList.get(position);

        holder.imageViewAvatar.setImageResource(mContext.getResources().getIdentifier(calisanlar.getCalisan_resim(), "drawable", mContext.getPackageName()));
        holder.textViewIsim.setText("İsim : " + calisanlar.getCalisan_isim());
        holder.textViewMeslek.setText("Meslek : " + calisanlar.getCalisan_meslek());
        holder.textViewPlaka.setText("Araç Plakası : " + calisanlar.getCalisan_plaka());
        holder.textViewOylama.setText("Ortalama : " + calisanlar.getCalisan_rating());

        holder.buttonOyla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, OylamaActivity.class);
                intent.putExtra("calisanlar", calisanlar);
                mContext.startActivity(intent);
            }
        });

        holder.cardViewBirinci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivity.class);
                intent.putExtra("calisanlar", calisanlar);
                mContext.startActivity(intent);
            }
        });

        holder.buttonYorumYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, YorumActivity.class);
                intent.putExtra("calisanlar", calisanlar);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return calisanlarArrayList.size();
    }

    public class CardViewTutucu extends RecyclerView.ViewHolder {
        protected ImageView imageViewAvatar;
        protected TextView textViewIsim, textViewMeslek, textViewPlaka, textViewOylama;
        protected Button buttonOyla;
        protected CardView cardViewBirinci;
        protected Button buttonYorumYap;

        public CardViewTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatarDurak);
            textViewIsim = itemView.findViewById(R.id.textViewIsimDurak);
            textViewMeslek = itemView.findViewById(R.id.textViewMeslekDurak);
            textViewPlaka = itemView.findViewById(R.id.textViewKonumDurak);
            textViewOylama = itemView.findViewById(R.id.textViewOylamaDurak);
            buttonOyla = itemView.findViewById(R.id.buttonDuraklar);
            cardViewBirinci = itemView.findViewById(R.id.cardViewUcuncu);
            buttonYorumYap = itemView.findViewById(R.id.buttonDuraklarYorumYap);
        }
    }
}
