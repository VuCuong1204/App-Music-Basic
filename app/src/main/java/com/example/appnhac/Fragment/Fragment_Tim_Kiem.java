package com.example.appnhac.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.R;
import com.example.appnhac.Adapter.SearchBaiHatAdapter;
import com.example.appnhac.Model.Baihat;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Tim_Kiem extends Fragment {
    View view;
    Toolbar toolbarsearchbaihat;
    AppBarLayout appBarLayoutsearchbaihat;
    RecyclerView recyclerViewsearchbaihat;
    TextView txtKhongcodulieu;
    SearchBaiHatAdapter searchBaiHatAdapter;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_tim_kiem,container,false);
       Anhxa();
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbarsearchbaihat);
        toolbarsearchbaihat.setTitle("Tìm kiếm tên bài hát và ca sĩ");
        toolbarsearchbaihat.setTitleTextColor(getResources().getColor(R.color.mauxam));
        setHasOptionsMenu(true);
        return view;
    }

    private void GetData(String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Baihat>> callback = dataservice.GetSearchbaihat(query);
        callback.enqueue(new Callback<List<Baihat>>() {
            @Override
            public void onResponse(Call<List<Baihat>> call, Response<List<Baihat>> response) {
                ArrayList<Baihat> baihatArrayList = (ArrayList<Baihat>) response.body();
                if(baihatArrayList.size()>0) {
                    searchBaiHatAdapter = new SearchBaiHatAdapter(getActivity(), baihatArrayList);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewsearchbaihat.setLayoutManager(linearLayoutManager);
                    recyclerViewsearchbaihat.setAdapter(searchBaiHatAdapter);
                    txtKhongcodulieu.setVisibility(View.GONE);
                    recyclerViewsearchbaihat.setVisibility(view.VISIBLE);
                }else{
                    recyclerViewsearchbaihat.setVisibility(View.GONE);
                    txtKhongcodulieu.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<List<Baihat>> call, Throwable t) {

            }
        });
    }

            private void Anhxa() {
                toolbarsearchbaihat = view.findViewById(R.id.toolbarsearchbaihat);
                appBarLayoutsearchbaihat = view.findViewById(R.id.appbarlayoutsearchbaihat);
                recyclerViewsearchbaihat = view.findViewById(R.id.recyclerviewsearchbaihat);
                txtKhongcodulieu = view.findViewById(R.id.textviewkhongcodulieu);
            }


    @Override
    public void onCreateOptionsMenu( Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menusearch);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                GetData(newText);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}
