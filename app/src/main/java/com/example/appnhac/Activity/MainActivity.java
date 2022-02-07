package com.example.appnhac.Activity;

import android.app.Activity;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import com.example.appnhac.Adapter.MainViewPagerAdapter;
import com.example.appnhac.Fragment.Fragment_Tim_Kiem;
import com.example.appnhac.Fragment.Fragment_Trang_Chu;
import com.example.appnhac.Activity.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        init();
    }

    private void init(){
       MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
       mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu());
       mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem());
       viewPager.setAdapter(mainViewPagerAdapter);
       tabLayout.setupWithViewPager(viewPager);
       tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
       tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }
    private void Anhxa() {
        tabLayout = (TabLayout) findViewById(R.id.myTabLayout);
        viewPager = (ViewPager) findViewById(R.id.myViewLayout);
    }
}
