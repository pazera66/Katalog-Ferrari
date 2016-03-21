package com.example.pazera.katalogferrari;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by pazera on 2014-08-21.
 */
public class LandscapeFragment extends Fragment {

    public Activity activity;

//    public View LandscapeFragment(Activity _activity, LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        this.activity = _activity;
//         ImageView bigImage = (ImageView) this.activity.findViewById(R.id.big);
//         bigImage.setImageResource(R.drawable.f1);
//
//    return inflater.inflate(R.layout.landscape_fragment, container, false);
//}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      //  ImageView bigImage = (ImageView).getActivity();
      //  bigImage.setImageResource(R.drawable.f1);

        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Configuration config = getResources().getConfiguration();


        if (config.orientation == Configuration.ORIENTATION_PORTRAIT){
            transaction.hide(this);
        }

        return inflater.inflate(R.layout.landscape_fragment, container, false);
    }




}
