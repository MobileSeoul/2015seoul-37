package com.example.benjamin.snowday;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

//import com.example.benjamin.snowday.model.Location;
/**
 * Created by Chase on 4/23/15.
 */
public class Output extends MainActivity{



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.output);



        //     Intent intent = getIntent();

        pager = (ViewPager) findViewById(R.id.pager);
  //  String city = "seoul";
  String loc = "lat=37.65875&lon=126.9777&appid=bd82977b86bf27fb59a04b61b657fb6f";

//   ActionBar ab = getActionBar();
   // ab.setDisplayHomeAsUpEnabled(true);
        JSONWeatherTask task = new JSONWeatherTask();
        task.execute(new String[]{loc});//from city
        JSONForecastWeatherTask task1 = new JSONForecastWeatherTask();
        task1.execute(new String[]{loc, "en", "7"});
    cityText = (TextView) findViewById(R.id.cityText);
    condDescr = (TextView) findViewById(R.id.skydesc);
    temp = (TextView) findViewById(R.id.temp);
        imgView = (ImageView) findViewById(R.id.condIcon);



    }

}


