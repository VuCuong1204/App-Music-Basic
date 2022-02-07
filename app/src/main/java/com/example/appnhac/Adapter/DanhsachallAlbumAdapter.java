package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Activity.R;
import com.example.appnhac.Model.Album;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DanhsachallAlbumAdapter extends RecyclerView.Adapter<DanhsachallAlbumAdapter.ViewHolder>{

   Context context;
   ArrayList<Album> mangtatcaalbum;

    public DanhsachallAlbumAdapter(Context context, ArrayList<Album> mangtatcaalbum) {
        this.context = context;
        this.mangtatcaalbum = mangtatcaalbum;
    }
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_all_album,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DanhsachallAlbumAdapter.ViewHolder holder, int position) {
         Album album = mangtatcaalbum.get(position);
         holder.txtTenAlbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imgAlbum);
    }

    @Override
    public int getItemCount() {
        return mangtatcaalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAlbum;
        TextView txtTenAlbum;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAlbum = itemView.findViewById(R.id.imageviewallalbum);
            txtTenAlbum = itemView.findViewById(R.id.textviewallalbum);

            imgAlbum.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("idalbum",mangtatcaalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
