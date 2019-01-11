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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;
import com.shivam.computernetworking.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiffieHellman extends android.app.Fragment {

    public DiffieHellman() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_diffie_hellman, container, false);
        final TextView textView = rootview.findViewById(R.id.textiewdiffiehellman);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol7);
        final HighlightJsView highlightJsView = (HighlightJsView)rootview.findViewById(R.id.code7);

        final LinearLayout li=rootview.findViewById(R.id.LINEAR);
        final EditText input=rootview.findViewById(R.id.INPUT);
        final TextView Console=rootview.findViewById(R.id.CONSOLE);
        final TextView inputtext=rootview.findViewById(R.id.INPUTTEXT);
        final Button submit=rootview.findViewById(R.id.SUBMIT);



        final String[] str = {""};
        final int[] i = {0};
        final BigInteger[] p = {null};
        final BigInteger[] x = { null };
        final BigInteger[] R1 = { null };
        final BigInteger[] g = {null};
        final BigInteger[] y = { null };

        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                li.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;


                            case R.id.code:
                                li.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.VISIBLE);
                                highlightJsView.setTheme(Theme.ARDUINO_LIGHT);
                                highlightJsView.setHighlightLanguage(Language.JAVA);

                                try {
                                    highlightJsView.setSource(new URL("https://raw.githubusercontent.com/shivamgarg11/ComputerNetworking/master/Deffie_Hellman.txt"));
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }

                                break;

                            case R.id.tryit:
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                li.setVisibility(View.VISIBLE);

                                str[0]="";
                                p[0] =null;
                                x[0] =null;
                                y[0] =null;
                                g[0] =null;
                                R1[0] =null;
                                Console.setText(str[0]);
                                inputtext.setText("Enter prime number:");
                                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));





                                break;
                        }
                        return false;
                    }
                });





        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(i[0] ==0) {
                    p[0] = new BigInteger(input.getText().toString());
                    i[0] =1;
                    inputtext.setText("Enter primitive root of " + p[0] + ":");
                    input.setText("");
                }


               else if(i[0] ==1) {

                    g[0] = new BigInteger(String.valueOf(input.getText().toString()));
                    i[0] =2;
                    inputtext.setText("Enter value for x less than " + p[0] + ":");
                    input.setText("");
                }

               else if(i[0] ==2) {

                    x[0] = new BigInteger(String.valueOf(input.getText().toString()));
                    R1[0] = g[0].modPow(x[0], p[0]);
                    str[0] += "\n" + "R1=" + R1[0];
                    Console.setText(str[0]);
                    i[0] =3;
                    inputtext.setText("Enter value for y less than " + p[0] + ":");
                    input.setText("");
                }

               else if(i[0] ==3) {

                    y[0] = new BigInteger(String.valueOf(input.getText().toString()));
                    i[0] =4;
                    input.setText("");
                }

                if(i[0] ==4) {
                    BigInteger R2 = g[0].modPow(y[0], p[0]);
                    str[0] += "\n" + "R2=" + R2;
                    Console.setText(str[0]);
                    BigInteger k1 = R2.modPow(x[0], p[0]);
                    str[0] += "\n" + "Key calculated at Alice's side:" + k1;
                    Console.setText(str[0]);
                    BigInteger k2 = R1[0].modPow(y[0], p[0]);
                    str[0] += "\n" + "Key calculated at Bob's side:" + k2;
                    str[0] += "\n" + "deffie hellman secret key Encryption has Taken";
                    Console.setText(str[0]);
                    i[0] =0;
                    input.setText("");
                    inputtext.setText("");
                }
            }
        });

        return  rootview;}



}
