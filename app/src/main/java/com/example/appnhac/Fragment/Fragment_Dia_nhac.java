package com.example.appnhac.Fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appnhac.Activity.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Fragment_Dia_nhac extends Fragment {

    View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_dia_nhac,container,false);
       circleImageView = view.findViewById(R.id.imageviewcircle);
       objectAnimator = ObjectAnimator.ofFloat(circleImageView,"rotation",0f,360f);
       objectAnimator.setDuration(10000);
       objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
       objectAnimator.setRepeatMode(ValueAnimator.RESTART);
       objectAnimator.setInterpolator(new LinearInterpolator());
       objectAnimator.start();
        return view;
    }

    public void PlayNhac(String hinhanh) {
        Picasso.with(getActivity()).load(hinhanh).into(circleImageView);
    }
}
