package com.daffzzaqihaq.topexpensivefood;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daffzzaqihaq.topexpensivefood.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    int[] gambar;
    String[] nama,detail;

    public Adapter(Context context,int[] gambar, String[] nama, String[] detail){
        this.context = context;
        this.gambar = gambar;
        this.nama = nama;
        this.detail = detail;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(nama[i]);
        Glide.with(context).load(gambar[i]).into(viewHolder.imgLogo);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context,Detail.class);
                pindah.putExtra("n",nama[i]);
                pindah.putExtra("d",detail[i]);
                pindah.putExtra("g",gambar[i]);
                context.startActivity(pindah);

            }
        });
    }



    @Override
    public int getItemCount() {
        return gambar.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgList);
            txtNama = itemView.findViewById(R.id.txtListTitle);

        }
    }
}

