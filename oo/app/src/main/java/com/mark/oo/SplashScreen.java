package com.mark.oo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class SplashScreen extends AppCompatActivity {
    Handler hd = new Handler();

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView = findViewById(R.id.imageView3);

        Glide.with(this).load(R.drawable.intro).into(imageView);
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent Mainintent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(Mainintent);
                finish();
            }
        }, 3000);

    }

}
