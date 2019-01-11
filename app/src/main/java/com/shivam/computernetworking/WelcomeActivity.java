package com.shivam.computernetworking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.skyfishjy.library.RippleBackground;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class WelcomeActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        final RippleBackground rippleBackground=findViewById(R.id.content);
                rippleBackground.startRippleAnimation();


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                rippleBackground.stopRippleAnimation();
                finish();
            }
        }, 4000);


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                ImageView image1=findViewById(R.id.image1);
                image1.setVisibility(View.VISIBLE);
            }
        }, 1000);



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                ImageView image2=findViewById(R.id.image2);
                image2.setVisibility(View.VISIBLE);
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                ImageView image3=findViewById(R.id.image3);
                image3.setVisibility(View.VISIBLE);
            }
        }, 2500);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                ImageView image4=findViewById(R.id.image4);
                image4.setVisibility(View.VISIBLE);
            }
        }, 4000);


    }
}
