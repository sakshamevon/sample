package com.example.animationsplash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView view=findViewById(R.id.logo);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        view.startAnimation(animation);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    super.run();
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        };
        timer.start();
    }
}