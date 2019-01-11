package com.shivam.computernetworking.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.shivam.computernetworking.Algos.selectivendrep;

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
public class SelectiveRepeat extends android.app.Fragment {

    public SelectiveRepeat() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_selective_repeat, container, false);


        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);
        final TextView textView = rootview.findViewById(R.id.textiewselectiverepeat);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol2);
        final HighlightJsView highlightJsView = rootview.findViewById(R.id.code2);

        final TextView console2=rootview.findViewById(R.id.console2);
        final EditText input=rootview.findViewById(R.id.input2);
        final Button btn2=rootview.findViewById(R.id.submit2);

        final ScrollView scroll22=rootview.findViewById(R.id.scroll22);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                scroll22.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                break;
                            case R.id.code:
                                scroll22.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.VISIBLE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setTheme(Theme.ARDUINO_LIGHT);
                                highlightJsView.setHighlightLanguage(Language.JAVA);

                                try {
                                    highlightJsView.setSource(new URL("https://raw.githubusercontent.com/shivamgarg11/ComputerNetworking/master/selectiverepeat.txt"));
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }

                                break;

                            case R.id.tryit:
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.GONE);
                                scroll22.setVisibility(View.VISIBLE);


                                btn2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        selectivendrep selectivendrep=new selectivendrep();
                                        String str=selectivendrep.input(Integer.valueOf(input.getText().toString()));
                                        console2.setText(str);
                                        input.setText("");
                                    }
                                });




                                break;
                        }
                        return false;
                    }
                });

        return  rootview;}



}
