package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Activity.R;
import com.example.appnhac.Model.Theloai;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TheloaitheochudeAdapter extends RecyclerView.Adapter<TheloaitheochudeAdapter.ViewHolder> {
   Context context;
   ArrayList<Theloai> mangtheloai;

    public TheloaitheochudeAdapter(Context context, ArrayList<Theloai> mangtheloai) {
        this.context = context;
        this.mangtheloai = mangtheloai;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_theloai_theo_chude,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( TheloaitheochudeAdapter.ViewHolder holder, int position) {
      Theloai theloai = mangtheloai.get(position);
        Picasso.with(context).load(theloai.getHinhTheLoai()).into(holder.imgtheloaitheochude);
       holder.txttentheloaitheochude.setText(theloai.getTenTheLoai());
    }

    @Override
    public int getItemCount() {
        return mangtheloai.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgtheloaitheochude;
        TextView txttentheloaitheochude;
        public ViewHolder( View itemView) {
            super(itemView);
            imgtheloaitheochude = itemView.findViewById(R.id.imageviewtheloaitheochude);
            txttentheloaitheochude = itemView.findViewById(R.id.textviewtentheloaitheochude);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("idtheloai",mangtheloai.get(getPosition()));
                context.startActivity(intent);
            }
        });
        }
    }
}
