package com.example.zetacontest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class Splash extends AppCompatActivity {

    private static long Splash_time_out = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(isNetworkConnected(this)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                        Intent homeIntent = new Intent(Splash.this, MainActivity.class);
                        startActivity(homeIntent);
                        finish();
                }
            },Splash_time_out);
        }
        else {
            Toast.makeText(getApplicationContext(), "Network unavailable...",Toast.LENGTH_LONG).show();

        }
    }

    private boolean isNetworkConnected(Splash context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo mob = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if(mob != null && mob.isConnected() || wifi != null && wifi.isConnected() )
            return true;
        else
            return false;
    }
}