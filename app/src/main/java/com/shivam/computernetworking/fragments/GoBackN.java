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
import com.shivam.computernetworking.R;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class GoBackN extends android.app.Fragment {


    public GoBackN() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_go_back_n, container, false);
        final TextView textView = rootview.findViewById(R.id.textiewgobackn);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol5);
        final HighlightJsView highlightJsView = (HighlightJsView)rootview.findViewById(R.id.code5);
        final ScrollView scroll55=rootview.findViewById(R.id.Scrol55);
        final ScrollView scroll555=rootview.findViewById(R.id.Scrol555);


        final EditText input=rootview.findViewById(R.id.INPUT5);
        final TextView Console=rootview.findViewById(R.id.CONSOLE5);
        final TextView inputtext=rootview.findViewById(R.id.INPUTTEXT5);
        final Button submit=rootview.findViewById(R.id.SUBMIT5);


        final int[] windowsize = new int[1];
        final int[] sent = {0};
        final int[] ack = new int[1];
        final String[] str = {""};

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                scroll555.setVisibility(View.GONE);
                                scroll55.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;


                            case R.id.code:
                                scroll555.setVisibility(View.GONE);
                                scroll55.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.VISIBLE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setTheme(Theme.ARDUINO_LIGHT);
                                highlightJsView.setHighlightLanguage(Language.AUTO_DETECT);

                                try {
                                    highlightJsView.setSource(new URL("https://raw.githubusercontent.com/shivamgarg11/ComputerNetworking/master/gobackn.txt"));
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                                break;


                            case R.id.tryit:
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                scroll55.setVisibility(View.VISIBLE);
                                scroll555.setVisibility(View.VISIBLE);
                                windowsize[0]=0;
                                sent[0] =0;
                                str[0] ="";
                                inputtext.setText("Enter window size");
                                Console.setText(str[0]);

                        }
                        return false;
                    }
                });


        final int[] j = {0};


submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(j[0] ==0){
            windowsize[0] =Integer.valueOf(input.getText().toString());
            input.setText("");
            j[0]=1;

        }


        if(j[0] ==1){
            while(true)
            {
                for(int i = 0; i < windowsize[0]; i++)
                {
                   str[0]="Frame "+ sent[0] +"has been transmitted.\n"+str[0];
                   Console.setText(str[0]);
                    sent[0]++;
                    if(sent[0] == windowsize[0])
                        break;
                }

                inputtext.setText("\nPlease enter the last Acknowledgement received.\n");
                j[0]=2;
                break;

            }
        }else if(j[0]==2){

            ack[0] =Integer.valueOf(input.getText().toString());
            input.setText("");

            if(ack[0] == windowsize[0]){
                j[0]=3;
            inputtext.setText("");
            }
            else{
                j[0]=1;
                sent[0] = ack[0];
            submit.callOnClick();
            }
        }

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
