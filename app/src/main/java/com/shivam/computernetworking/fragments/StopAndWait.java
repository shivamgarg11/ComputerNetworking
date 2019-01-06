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

import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;
import com.shivam.computernetworking.R;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopAndWait extends android.app.Fragment {

    public StopAndWait() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_stop_and_wait, container, false);

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);
        final TextView textView = rootview.findViewById(R.id.textiewstopandwait);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol1);
        final ScrollView scroll11=rootview.findViewById(R.id.scrol11);
        final HighlightJsView highlightJsView = (HighlightJsView)rootview.findViewById(R.id.code1);

         final LinearLayout linear=rootview.findViewById(R.id.LINEAR1);
         final TextView console=rootview.findViewById(R.id.console1);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {


                            case R.id.descriptions:
                                scroll11.setVisibility(View.GONE);
                                linear.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;

                            case R.id.code:
                                scroll11.setVisibility(View.GONE);
                                linear.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.VISIBLE);
                                highlightJsView.setTheme(Theme.ARDUINO_LIGHT);
                                highlightJsView.setHighlightLanguage(Language.AUTO_DETECT);

                                try {
                                    highlightJsView.setSource(new URL("https://raw.githubusercontent.com/shivamgarg11/ComputerNetworking/master/stopandwait.txt"));
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }


                            case R.id.tryit:
                                scroll11.setVisibility(View.VISIBLE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                linear.setVisibility(View.VISIBLE);

                                String str="";

                                int i,j,noframes,x,x1=10,x2;
                                for(i=0;i<2;i++)
                                    Math.random();
                                noframes= (int) (Math.random()*100);
                                i=1;
                                j=1;
                                noframes = noframes / 8;
                                str+="\n number of frames is :"+noframes;
                                console.setText(str);
                                while(noframes>0)
                                {
                                    str+="\nsending frame :"+i;
                                    console.setText(str);
                                    SecureRandom srand=new SecureRandom();
                                    srand.generateSeed(x1++);
                                    x = (int) ((Math.random()*100)%10);
                                    if(x%2 == 0)
                                    {
                                        for (x2=1; x2<2; x2++)
                                        {
                                            str+="\nwaiting for "+x2+"seconds\n";
                                            console.setText(str);
                                        }
                                       str+="\nsending frame :"+i;
                                        console.setText(str);
                                        srand.generateSeed(x1++);
                                        x = (int) ((Math.random()*100)%10);
                                    }
                                    str+="\nack for frame :"+j;
                                    console.setText(str);
                                    noframes-=1;
                                    i++;
                                    j++;
                                }
                               str+="\n end of stop and wait protocol";
                                console.setText(str);
                                break;
                        }
                        return false;
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
