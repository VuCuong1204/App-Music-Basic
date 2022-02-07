package com.example.appnhac.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.R;
import com.example.appnhac.Model.Baihat;

import java.util.ArrayList;

public class PhatnhacAdapter extends RecyclerView.Adapter<PhatnhacAdapter.Viewholder> {

    Context context;
    ArrayList<Baihat> mangbaihat;

    public PhatnhacAdapter(Context context, ArrayList<Baihat> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_phat_nhac,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder( PhatnhacAdapter.Viewholder holder, int position) {
        Baihat baihat = mangbaihat.get(position);
        holder.txtphatnhacindex.setText(position+1+"");
        holder.txtphatnhactenbaihat.setText(baihat.getTenBaiHat());
        holder.txtphatnhactencasi.setText(baihat.getCaSi());
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView txtphatnhacindex,txtphatnhactenbaihat,txtphatnhactencasi;
        public Viewholder( View itemView) {
            super(itemView);
            txtphatnhacindex = itemView.findViewById(R.id.textviewphatnhacindex);
            txtphatnhactenbaihat = itemView.findViewById(R.id.textviewphatnhactenbaihat);
            txtphatnhactencasi = itemView.findViewById(R.id.textviewphatnhactencasi);
        }
    }
}
