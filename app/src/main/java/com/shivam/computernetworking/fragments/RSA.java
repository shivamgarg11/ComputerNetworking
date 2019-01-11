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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;
import com.shivam.computernetworking.Algos.RSA_Algo;
import com.shivam.computernetworking.R;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class RSA extends android.app.Fragment {


    public RSA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_r, container, false);

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);
        final TextView textView = rootview.findViewById(R.id.textiewrsa);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol3);
        final HighlightJsView highlightJsView = (HighlightJsView)rootview.findViewById(R.id.code3);
        final View tryit = rootview.findViewById(R.id.Scrol55);
        final Button submit=rootview.findViewById(R.id.SUBMIT5);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                highlightJsView.setVisibility(View.GONE);
                                tryit.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;
                            case R.id.code:
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.VISIBLE);
                                tryit.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setTheme(Theme.ARDUINO_LIGHT);
                                highlightJsView.setHighlightLanguage(Language.JAVA);

                                try {
                                    highlightJsView.setSource(new URL("https://raw.githubusercontent.com/shivamgarg11/ComputerNetworking/master/RSA.txt"));
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }

                                break;

                            case R.id.tryit:
                                tryit.setVisibility(View.VISIBLE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);

                        }
                        return false;
                    }
                });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = ((EditText)rootview.findViewById(R.id.INPUT5)).getText().toString().trim();
                try {
                    str = RSA_Algo.Start(str);

                } catch (IOException e) {
                    e.printStackTrace();
                    str = "Unable to execute!";
                }

                ((TextView)rootview.findViewById(R.id.CONSOLE5)).setText(str);

            }

        });

        return  rootview;}

    static class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
