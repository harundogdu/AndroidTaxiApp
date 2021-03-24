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

public class DurakSoforListesiAdapter extends RecyclerView.Adapter<DurakSoforListesiAdapter.CardViewTutucu> {
    private Context mContext;
    private ArrayList<Calisanlar> calisanlarArrayList;

    public DurakSoforListesiAdapter(Context mContext, ArrayList<Calisanlar> calisanlarArrayList) {
        this.mContext = mContext;
        this.calisanlarArrayList = calisanlarArrayList;
    }

    @NonNull
    @Override
    public DurakSoforListesiAdapter.CardViewTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim_soforlistesi, parent, false);
        return new DurakSoforListesiAdapter.CardViewTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DurakSoforListesiAdapter.CardViewTutucu holder, int position) {
        Calisanlar calisanlar = calisanlarArrayList.get(position);

        holder.textViewSoforListesiIsim.setText("İsim : " + calisanlar.getCalisan_isim());
        holder.imageViewDurakSofor.setImageResource(mContext.getResources().getIdentifier(calisanlar.getCalisan_resim(),"drawable",mContext.getPackageName()));

        holder.cardViewSoforListesi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetayActivity.class);
                intent.putExtra("calisanlar", calisanlar);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return calisanlarArrayList.size();
    }

    public class CardViewTutucu extends RecyclerView.ViewHolder {
        protected TextView textViewSoforListesiIsim;
        protected CardView cardViewSoforListesi;
        protected ImageView imageViewDurakSofor;

        public CardViewTutucu(@NonNull View itemView) {
            super(itemView);
            textViewSoforListesiIsim = itemView.findViewById(R.id.textViewSoforListesiIsim);
            cardViewSoforListesi = itemView.findViewById(R.id.cardViewSoforListesi);
            imageViewDurakSofor = itemView.findViewById(R.id.imageViewDurakSofor);
        }
    }

}
