package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.appnhac.Adapter.DanhsachtatcachudeAdapter;
import com.example.appnhac.Model.Chude;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcachudeActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerViewallchude;
    DanhsachtatcachudeAdapter danhsachtatcachudeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtatcachude);
        Anhxa();
        Init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Chude>> callback = dataservice.GetChude();
        callback.enqueue(new Callback<List<Chude>>() {
            @Override
            public void onResponse(Call<List<Chude>> call, Response<List<Chude>> response) {
                ArrayList<Chude> arrayallchude = (ArrayList<Chude>) response.body();
            danhsachtatcachudeAdapter = new DanhsachtatcachudeAdapter(DanhsachtatcachudeActivity.this,arrayallchude);
           LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DanhsachtatcachudeActivity.this);
           linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
           recyclerViewallchude.setLayoutManager(linearLayoutManager);
            recyclerViewallchude.setAdapter(danhsachtatcachudeAdapter);

            }

            @Override
            public void onFailure(Call<List<Chude>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Danh Sách Tất Cả Chủ Đề");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {  finish();}
        });
    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarallchude);
        recyclerViewallchude = findViewById(R.id.recyclerviewAllchude);
    }
}