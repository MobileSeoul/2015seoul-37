package com.example.benjamin.snowday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Stopwatch extends Activity {
    ArrayList<Mountain> mountainlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_stopwatch);
        ListView listView = (ListView)findViewById(R.id.listview);
        mountainlist = new ArrayList<Mountain>();

        mountainlist.add(new Mountain("북한산", "서울특별시 강북구 우이동", R.drawable.bh));
        mountainlist.add(new Mountain("수락산", "서울특별시 노원구 상계동", R.drawable.sr));
        mountainlist.add(new Mountain("불암산", "서울특별시 노원구 상계동", R.drawable.ba));
        mountainlist.add(new Mountain("아차산", "서울특별시 광진구 광장동", R.drawable.ac));
        mountainlist.add(new Mountain("청계산", "서울특별시 서초구 원지동", R.drawable.cg));



        MountainAdapter mountainAdapter = new MountainAdapter(this, R.layout.mountain_detail, mountainlist);
        listView.setDivider(null);
        listView.setAdapter(mountainAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {
                    if (position == 0)  {

                        Intent intent = new Intent(Stopwatch.this, Bmap.class);

                        startActivity(intent);
                    } else if (position == 1)  {
                        Intent intent = new Intent(Stopwatch.this, Smap.class);

                        startActivity(intent);
                    }  else if (position == 2) {
                        Intent intent = new Intent(Stopwatch.this, B1map.class);

                        startActivity(intent);
                    }  else if (position == 3) {
                        Intent intent = new Intent(Stopwatch.this, Amap.class);


                        startActivity(intent);
                    }  else if (position == 4)  {
                        Intent intent = new Intent(Stopwatch.this, Cmap.class);

                        startActivity(intent);
                    }


                }

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stopwatch, menu);
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
