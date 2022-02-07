package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.appnhac.Adapter.TheloaitheochudeAdapter;
import com.example.appnhac.Model.Chude;
import com.example.appnhac.Model.Theloai;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtheloaitheochudeActivity extends AppCompatActivity {

    Toolbar toolbartheloaitheochude;
    RecyclerView recyclerView;
    TheloaitheochudeAdapter theloaitheochudeAdapter;
    Chude chude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsachtheloaitheochude);
        Intent intent =getIntent();
         chude = (Chude) intent.getSerializableExtra("idchude");
        Anhxa();
        Init();
        GetData(chude.getIdChuDe());
    }

    private void GetData(String idchude) {
        Dataservice dataservice = APIService.getService();
        Call<List<Theloai>> callback = dataservice.GetTheloaitheochude(idchude);
        callback.enqueue(new Callback<List<Theloai>>() {
            @Override
            public void onResponse(Call<List<Theloai>> call, Response<List<Theloai>> response) {
                ArrayList<Theloai> mangtheloaitheochude = (ArrayList<Theloai>) response.body();
             theloaitheochudeAdapter = new TheloaitheochudeAdapter(DanhsachtheloaitheochudeActivity.this,mangtheloaitheochude);
                recyclerView.setLayoutManager(new GridLayoutManager(DanhsachtheloaitheochudeActivity.this,2));
                recyclerView.setAdapter(theloaitheochudeAdapter);
            }

            @Override
            public void onFailure(Call<List<Theloai>> call, Throwable t) {

            }
        });
    }

    private void Init() {
        setSupportActionBar(toolbartheloaitheochude);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(chude.getTenChuDe());
        toolbartheloaitheochude.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toolbartheloaitheochude = findViewById(R.id.toolbartheloaitheochude);
        recyclerView = findViewById(R.id.recyclerviewtheloaitheochude);
    }
}