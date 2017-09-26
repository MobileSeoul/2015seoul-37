package com.example.benjamin.snowday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Camera extends MainActivity {
    private WebView webView;
    ArrayList<Mountain> mountainlist;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // ActionBar ab = getActionBar();
        // ab.setHomeButtonEnabled(true);
        //  ab.setDisplayHomeAsUpEnabled(true);
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

                        Intent intent = new Intent(Camera.this, Bm.class);

                        startActivity(intent);
                    } else if (position == 1)  {
                        Intent intent = new Intent(Camera.this, Sm.class);

                        startActivity(intent);
                    }  else if (position == 2) {
                        Intent intent = new Intent(Camera.this, Bbm.class);

                        startActivity(intent);
                    }  else if (position == 3) {
                        Intent intent = new Intent(Camera.this, Am.class);

                        startActivity(intent);
                    }  else if (position == 4)  {
                        Intent intent = new Intent(Camera.this, Cm.class);

                        startActivity(intent);
                    }


                }

            }

        });


    /*    Toast.makeText(getApplicationContext(),"화면을 돌리면 사진이 크게 보여요!", Toast.LENGTH_LONG).show();
     //  ActionBar ab = getActionBar();
     //  ab.setHomeButtonEnabled(false);
     //   ab.setDisplayHomeAsUpEnabled(false);
        setContentView(R.layout.activity_camera);
        webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.naver.com");
        webView.setWebViewClient(new WebViewClient());

        //     Intent intent = getIntent();

        pager = (ViewPager) findViewById(R.id.pager);
        String city = "seoul";
        String loc = "lat=37.573927&lon=127.023709";



      ActionBar ab = getActionBar();

        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{loc});//from city
      //  JSONForecastWeatherTask task1 = new JSONForecastWeatherTask();
       // task1.execute(new String[]{loc, "en", "7"});
        cityText = (TextView) findViewById(R.id.cityText);
        condDescr = (TextView) findViewById(R.id.skydesc);
        temp = (TextView) findViewById(R.id.temp);
        imgView = (ImageView) findViewById(R.id.condIcon);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_camera);
            webView = (WebView) findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://www.naver.com");
            webView.setWebViewClient(new WebViewClient());

            //     Intent intent = getIntent();

            pager = (ViewPager) findViewById(R.id.pager);
            String city = "seoul";
            String loc = "lat=37.573927&lon=127.023709";



            ActionBar ab = getActionBar();

            JSONWeatherTask task = new JSONWeatherTask();
            task.execute(new String[]{loc});//from city
            //  JSONForecastWeatherTask task1 = new JSONForecastWeatherTask();
            // task1.execute(new String[]{loc, "en", "7"});
            cityText = (TextView) findViewById(R.id.cityText);
            condDescr = (TextView) findViewById(R.id.skydesc);
            temp = (TextView) findViewById(R.id.temp);
            imgView = (ImageView) findViewById(R.id.condIcon);

            Toast.makeText(getApplicationContext(),"화면을 돌리면 사진이 크게 보여요!", Toast.LENGTH_LONG).show();
        } else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_camera);
            webView = (WebView) findViewById(R.id.webview);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://www.naver.com");
            webView.setWebViewClient(new WebViewClient());

       // 67     Toast.makeText(getApplicationContext(),"화면을 돌리면 사진이 작게 보여요..", Toast.LENGTH_LONG).show();
        }
        super.onConfigurationChanged(newConfig);
    }

    private class WebViewClient extends android.webkit.WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return  true;
        }
    }*/
    }
}