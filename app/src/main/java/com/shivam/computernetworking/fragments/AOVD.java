package com.shivam.computernetworking.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.shivam.computernetworking.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AOVD extends android.app.Fragment {


    public AOVD() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_aovd, container, false);
        final TextView textView = rootview.findViewById(R.id.textiewaovd);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol8);
       final WebView wb=rootview.findViewById(R.id.web1);



        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                wb.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;
                            case R.id.code:

                                break;
                        }
                        return false;
                    }
                });

    return  rootview;}


}
