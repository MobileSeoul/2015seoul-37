package com.example.benjamin.snowday;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ImageView;

public class Splash extends Activity {
    ImageView mt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_splash);
  /*    mt = (ImageView)findViewById(R.id.mt);

        Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);




        mt.startAnimation(rotate);*/



        initialize();

    }

    private void initialize()
    {
        Handler handler =    new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                finish();
            }
        }, 5000);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
