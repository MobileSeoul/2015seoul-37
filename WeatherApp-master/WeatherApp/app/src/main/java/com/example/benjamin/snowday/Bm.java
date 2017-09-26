package com.example.benjamin.snowday;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import java.util.List;
import java.util.Vector;

public class Bm extends FragmentActivity {

    private  PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view);
        Toast.makeText(getApplicationContext(), "좌우로 드래그하면 다른 사진이 보여집니다.", Toast.LENGTH_LONG).show();
        initialisePaging();
    }

    private void initialisePaging() {
        List<Fragment> fregments = new Vector<Fragment>();
        fregments.add(Fragment.instantiate(this, BSpring.class.getName()));
        fregments.add(Fragment.instantiate(this, Bsummer.class.getName()));
        fregments.add(Fragment.instantiate(this, Bfall.class.getName()));
        fregments.add(Fragment.instantiate(this, Bwinter.class.getName()));

        mPagerAdapter = new PagerAdapter(this.getSupportFragmentManager(), fregments);
        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(mPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bm, menu);
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
