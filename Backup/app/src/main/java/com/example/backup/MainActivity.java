package com.example.backup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout splash_screen_layout = (LinearLayout) findViewById(R.id.splash_screen_layout);
        final LinearLayout signin_signup_layout = (LinearLayout) findViewById(R.id.signin_signup_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splash_screen_layout.animate().alpha(0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        splash_screen_layout.setVisibility(View.GONE);
                        signin_signup_layout.setVisibility(View.VISIBLE);

                    }
                });
            }
        }, 2000);
    }

    public void Login(View view) {
        final LinearLayout signin_signup_layout = (LinearLayout) findViewById(R.id.signin_signup_layout);
        final LinearLayout login_layout = (LinearLayout) findViewById(R.id.login_layout);

        signin_signup_layout.animate().alpha(0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                signin_signup_layout.setVisibility(View.GONE);
                signin_signup_layout.setAlpha(1);
                login_layout.setVisibility(View.VISIBLE);
            }
        });
    }

    public void GoHome(View view) {
        /*final LinearLayout login_layout = (LinearLayout) findViewById(R.id.login_layout);
        final LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_layout);


        login_layout.animate().alpha(0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                login_layout.setVisibility(View.GONE);
                login_layout.setAlpha(1);
                home_layout.setVisibility(View.VISIBLE);
            }
        });*/

        startActivity(new Intent(MainActivity.this, NavbarActivity.class));
    }

    public void GoAccueil(View view) {
        final LinearLayout accueil_layout = (LinearLayout) findViewById(R.id.accueil_layout);
        final LinearLayout home_layout = (LinearLayout) findViewById(R.id.home_layout);

        home_layout.animate().alpha(0f).setDuration(300).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                home_layout.setVisibility(View.GONE);
                home_layout.setAlpha(1);
                accueil_layout.setVisibility(View.VISIBLE);
            }
        });
    }
}
