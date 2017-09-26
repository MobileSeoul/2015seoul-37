package com.example.benjamin.snowday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;

public class MainActivity1 extends Activity {
    boolean m_close_flag = false;
    Handler m_close_handler = new Handler() {
        public void handleMessage(Message msg) {
            m_close_flag = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      startActivity(new Intent(this, Splash.class));

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main1);


    }

   public void click1(View v) {
       Intent intent = new Intent(MainActivity1.this, Camera.class);
       startActivity(intent);
   }

    public void click2(View v) {
        Intent intent = new Intent(MainActivity1.this, MountainList.class);
        startActivity(intent);
    }

    public void click3(View v) {
        Intent intent = new Intent(MainActivity1.this, Stopwatch.class);
        startActivity(intent);

    }

}


