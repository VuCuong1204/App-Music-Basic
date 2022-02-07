package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.DanhsachtheloaitheochudeActivity;
import com.example.appnhac.Activity.R;
import com.example.appnhac.Model.Chude;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachtatcachudeAdapter extends RecyclerView.Adapter<DanhsachtatcachudeAdapter.Viewholder> {
Context context;
ArrayList<Chude> chudeArrayList;

    public DanhsachtatcachudeAdapter(Context context, ArrayList<Chude> chudeArrayList) {
        this.context = context;
        this.chudeArrayList = chudeArrayList;
    }

    @Override
    public Viewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cac_chu_de,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder( DanhsachtatcachudeAdapter.Viewholder holder, int position) {
       Chude chude = chudeArrayList.get(position);
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgChude);
    }

    @Override
    public int getItemCount() {
        return chudeArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgChude;
        public Viewholder(View itemView) {
            super(itemView);
            imgChude = itemView.findViewById(R.id.imageviewdongcacchude);
            imgChude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("idchude",chudeArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
