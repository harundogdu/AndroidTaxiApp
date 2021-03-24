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

public class DuraklarAdapter extends RecyclerView.Adapter<DuraklarAdapter.CardViewTutucu> {
    private Context mContext;
    private ArrayList<Duraklar> duraklarArrayList;

    public DuraklarAdapter(Context mContext, ArrayList<Duraklar> duraklarArrayList) {
        this.mContext = mContext;
        this.duraklarArrayList = duraklarArrayList;
    }

    @NonNull
    @Override
    public CardViewTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim_duraklar, parent, false);
        return new CardViewTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTutucu holder, int position) {
        Duraklar duraklar = duraklarArrayList.get(position);

        holder.imageViewAvatarDurak.setImageResource(mContext.getResources().getIdentifier(duraklar.getDuraklar_resim(), "drawable", mContext.getPackageName()));
        holder.textViewIsimDurak.setText(duraklar.getDuraklar_isim());
        holder.textViewMeslekDurak.setText(duraklar.getDuraklar_meslek());
        holder.textViewKonumDurak.setText(duraklar.getDuraklar_lokasyon());
        holder.textViewOylamaDurak.setText(String.valueOf(duraklar.getDuraklar_ortalama()));

        holder.buttonDuraklar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DurakSoforListesiActivity.class);
                intent.putExtra("duraklar", duraklar);
                mContext.startActivity(intent);
            }
        });

        holder.cardViewUcuncu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivityDuraklar.class);
                intent.putExtra("duraklar", duraklar);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return duraklarArrayList.size();
    }

    public class CardViewTutucu extends RecyclerView.ViewHolder {
        protected ImageView imageViewAvatarDurak;
        protected TextView textViewIsimDurak, textViewMeslekDurak, textViewKonumDurak, textViewOylamaDurak;
        protected Button buttonDuraklar;
        protected CardView cardViewUcuncu;

        public CardViewTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewAvatarDurak = itemView.findViewById(R.id.imageViewAvatarDurak);
            textViewIsimDurak = itemView.findViewById(R.id.textViewIsimDurak);
            textViewMeslekDurak = itemView.findViewById(R.id.textViewMeslekDurak);
            textViewKonumDurak = itemView.findViewById(R.id.textViewKonumDurak);
            textViewOylamaDurak = itemView.findViewById(R.id.textViewOylamaDurak);
            buttonDuraklar = itemView.findViewById(R.id.buttonDuraklar);
            cardViewUcuncu = itemView.findViewById(R.id.cardViewUcuncu);
        }
    }
}
