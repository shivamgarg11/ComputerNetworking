package com.shivam.computernetworking.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.pddstudio.highlightjs.HighlightJsView;
import com.pddstudio.highlightjs.models.Language;
import com.pddstudio.highlightjs.models.Theme;
import com.shivam.computernetworking.Algos.DVR;
import com.shivam.computernetworking.R;
import com.shivam.computernetworking.TrippleArrayInputAdapter;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class DistanceVector extends android.app.Fragment {


    int noOfVertices,noOfEdges;
    TrippleArrayInputAdapter adapter;


    public DistanceVector() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview= inflater.inflate(R.layout.fragment_distance_vector, container, false);
        final TextView textView = rootview.findViewById(R.id.textiewdistancevector);
        final ScrollView scroll1=rootview.findViewById(R.id.scrol6);
        final HighlightJsView highlightJsView = (HighlightJsView)rootview.findViewById(R.id.code6);
        final View tryit = rootview.findViewById(R.id.dvr);
        final TextView inputtext=rootview.findViewById(R.id.INPUTTEXT);
        final EditText inputEdittext=rootview.findViewById(R.id.INPUT);



        BottomNavigationView bottomNavigationView = rootview.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.descriptions:
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.VISIBLE);
                                textView.setVisibility(View.VISIBLE);
                                tryit.setVisibility(View.GONE);
                                break;


                            case R.id.code:
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setVisibility(View.VISIBLE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                highlightJsView.setTheme(Theme.ARDUINO_LIGHT);
                                highlightJsView.setHighlightLanguage(Language.JAVA);
                                tryit.setVisibility(View.GONE);


                                try {
                                    highlightJsView.setSource(new URL("https://raw.githubusercontent.com/shivamgarg11/ComputerNetworking/master/DVR.txt"));
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }

                                break;




                            case R.id.tryit:
                                highlightJsView.setVisibility(View.GONE);
                                scroll1.setVisibility(View.GONE);
                                textView.setVisibility(View.GONE);
                                tryit.setVisibility(View.VISIBLE);




                        }
                        return false;
                    }
                });

        final int[] i = {0};

        final View view1 = rootview.findViewById(R.id.temp);
        final View InputView = rootview.findViewById(R.id.RecyclerParent);



        rootview.findViewById(R.id.SUBMIT).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputtext.setText("");

                if(i[0] ==0) {
                    noOfVertices = Integer.parseInt(inputEdittext.getText().toString());
                    i[0] =1;
                    inputtext.setText("Enter no of edges: ");
                    inputEdittext.setText("");
                }


                else if(i[0] ==1) {

                    noOfEdges = Integer.parseInt(inputEdittext.getText().toString());
                    i[0] =0;
                    view1.setVisibility(View.GONE);
                    RecyclerView recyclerView= InputView.findViewById(R.id.recylcler);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    adapter = new TrippleArrayInputAdapter(noOfEdges);
                    recyclerView.setAdapter(adapter);
                    InputView.setVisibility(View.VISIBLE);

                }
            }
        });


        rootview.findViewById(R.id.edgeSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 int s[] = adapter.getFirstArray();
                 int d[] = adapter.getSecondArray();
                 int c[] = adapter.getThirdArray();


                ((TextView)rootview.findViewById(R.id.CONSOLE)).setText(DVR.Start(noOfVertices,noOfEdges,s,d,c));

            }
        });



        return  rootview;}
}
