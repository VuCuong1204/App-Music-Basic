package com.example.appnhac.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appnhac.Activity.R;
import com.example.appnhac.Activity.TrinhphatnhacActivity;
import com.example.appnhac.Adapter.PhatnhacAdapter;

public class Fragment_Play_Danh_Sach_Cac_Bai_Hat extends Fragment {
    RecyclerView recyclerViewdanhsachphatnhac;
   View view;
   PhatnhacAdapter phatnhacAdapter ;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_danh_sach_cac_bai_hat,container,false);
        Anhxa();
        return view;

    }

    private void Anhxa() {
        recyclerViewdanhsachphatnhac = view.findViewById(R.id.recyclerviewdanhsachphatnhac);
        if(TrinhphatnhacActivity.mangbaihat.size()>0) {
            phatnhacAdapter = new PhatnhacAdapter(getActivity(), TrinhphatnhacActivity.mangbaihat);
        }
        recyclerViewdanhsachphatnhac.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewdanhsachphatnhac.setAdapter(phatnhacAdapter);
    }
}
