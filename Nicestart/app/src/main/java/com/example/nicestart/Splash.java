package com.example.nicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.Space;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView rayo = findViewById(R.id.logo);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        rayo.startAnimation(animation);
        ImageView mSplash = findViewById(R.id.fondo);


        Glide.with(this)
                .load(R.drawable.fondo_mar)
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_700)))
                .into(mSplash);
        openApp();

    }
    public void openSplash(View v){
        Intent intent = new Intent(Splash.this,MainActivity.class);
        startActivity(intent);
    }
    private void openApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(Splash.this, Login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },5000);
    }
}