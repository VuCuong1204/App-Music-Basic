package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Activity.R;
import com.example.appnhac.Model.Playlist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DanhsachcacplaylistAdapter extends RecyclerView.Adapter<DanhsachcacplaylistAdapter.ViewHolder>{

    Context context;
    ArrayList<Playlist> danhsachplaylist;

    public DanhsachcacplaylistAdapter(Context context, ArrayList<Playlist> danhsachplaylist) {
        this.context = context;
        this.danhsachplaylist = danhsachplaylist;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danh_sach_cac_playlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( DanhsachcacplaylistAdapter.ViewHolder holder, int position) {
        Playlist playlist = danhsachplaylist.get(position);
         holder.txttencacplaylist.setText(playlist.getTen());
        Picasso.with(context).load(playlist.getHinhnen()).into(holder.imgdanhsachcacplaylist);
    }

    @Override
    public int getItemCount() {
        return danhsachplaylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txttencacplaylist,txtcasicacplaylist;
        ImageView imgdanhsachcacplaylist;
        public ViewHolder( View itemView) {
            super(itemView);

            txttencacplaylist = itemView.findViewById(R.id.textviewtendanhsachcacplaylist);
            txtcasicacplaylist = itemView.findViewById(R.id.textviewcasicacplaylist);
            imgdanhsachcacplaylist = itemView.findViewById(R.id.imageviewdanhsachcacplaylist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist",danhsachplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
