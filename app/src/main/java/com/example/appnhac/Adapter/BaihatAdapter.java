package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.DanhsachbaihatActivity;
import com.example.appnhac.Activity.R;
import com.example.appnhac.Activity.TrinhphatnhacActivity;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaihatAdapter extends RecyclerView.Adapter<BaihatAdapter.ViewHolder> {
    Context context;
    ArrayList<Baihat> baihatArrayList;
    Baihat baihat;

    public BaihatAdapter(Context context, ArrayList<Baihat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_danhsach_baihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaihatAdapter.ViewHolder holder, int position) {
        baihat = baihatArrayList.get(position);
       holder.txttenbaihat.setText(baihat.getTenBaiHat());
       holder.txttencasi.setText(baihat.getCaSi());
       holder.txtdanhsachindex.setText(position+1+"");
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtdanhsachindex,txttenbaihat,txttencasi;
        ImageView imglove;
        public ViewHolder( View itemView) {
            super(itemView);
            txtdanhsachindex = itemView.findViewById(R.id.textviewdanhsachindex);
            txttenbaihat = itemView.findViewById(R.id.textviewtenbaihat);
            txttencasi = itemView.findViewById(R.id.textviewtencasi);
            imglove = itemView.findViewById(R.id.imageviewluotthichdanhsachbaihat);
            imglove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imglove.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.GetupdateLuotThich("1",baihat.getIdBaiHat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if(ketqua.equals("Success")){
                                Toast.makeText(context, "Đã Thích", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(context, "Bị lỗi", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imglove.setEnabled(false);
                }
            });
           itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TrinhphatnhacActivity.class);
                    intent.putExtra("cakhuc",baihatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
