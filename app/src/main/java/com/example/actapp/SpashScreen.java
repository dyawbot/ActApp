package com.example.actapp;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actapp.db_connections.NetChangeList;


public class SpashScreen extends AppCompatActivity {

    Animation topAnimation;
    TextView name_app;

    private long ms = 0, spashTotalTime =4500;
    private boolean splashActive = true, pause = false;

    NetChangeList netChangeList = new NetChangeList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        LinearLayout ll = (LinearLayout) findViewById(R.id.my_splash);
        name_app = findViewById(R.id.title_name);
        topAnimation= AnimationUtils.loadAnimation(this, R.anim.top_animation);


        Thread thread= new Thread()
        {
            @Override
            public void run() {
//                super.run();

                try {
                    while (splashActive && ms<spashTotalTime)
                    {
                        if(!pause)
                        {
                            ms=ms+100;

                            if(ms == 100 )
                            {
                                Log.i("TIME", String.valueOf(ms));
                            }




                            sleep(100);
                        }
                    }
                }
               catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Log.i("FINALTIME", String.valueOf(ms));
                }
            }
        };thread.start();




    }

    @Override
    protected void onStart() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(netChangeList, filter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(netChangeList);
        super.onStop();
    }
}