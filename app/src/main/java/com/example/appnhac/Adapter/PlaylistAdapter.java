package com.example.appnhac.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appnhac.Activity.R;
import com.example.appnhac.Model.Playlist;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {

        super(context, resource, objects);
    }

    class ViewHolder{
        TextView txtTenplaylist;
        ImageView imgbackground,imgplaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       ViewHolder holder;
       if(convertView == null){
           LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.dong_playlist,null);
           holder = new ViewHolder();
           holder.txtTenplaylist = convertView.findViewById(R.id.textviewtenplaylist);
           holder.imgbackground = convertView.findViewById(R.id.imageviewbackgroupplaylist);
           holder.imgplaylist = convertView.findViewById(R.id.imageviewplaylist);
           convertView.setTag(holder);
       }else {
           holder = (ViewHolder) convertView.getTag();
       }
       Playlist playlist = getItem(position);

        Picasso.with(getContext()).load(playlist.getHinhnen()).into(holder.imgbackground);
        Picasso.with(getContext()).load(playlist.getHinhicon()).into(holder.imgplaylist);
        holder.txtTenplaylist.setText(playlist.getTen());
        return convertView;
    }
}
