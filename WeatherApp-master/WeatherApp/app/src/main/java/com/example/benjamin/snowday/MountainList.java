package com.example.benjamin.snowday;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.benjamin.snowday.adapter.DailyForecastPageAdapter;
import com.example.benjamin.snowday.model.Weather;
import com.example.benjamin.snowday.model.WeatherForecast;

import org.json.JSONException;

import java.util.ArrayList;

public class MountainList extends FragmentActivity {
    ArrayList<Mountain> mountainlist;

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";

    protected TextView textView11;
    protected TextView cityText;
    protected TextView condDescr;
    protected TextView temp;
    //private TextView press;
    //private TextView windSpeed;
    //private TextView windDeg;
    protected TextView unitTemp;
    protected ImageView imgView1;
    //private TextView hum;
    protected ImageView imgView;
    protected Button searchButton;
    // protected EditText locationString;

    private static String forecastDaysNum = "7";
    protected ViewPager pager;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_mountain_list);
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

                        Intent intent = new Intent(MountainList.this, Output.class);

                        startActivity(intent);
                    } else if (position == 1)  {
                        Intent intent = new Intent(MountainList.this, Output1.class);

                        startActivity(intent);
                    }  else if (position == 2) {
                        Intent intent = new Intent(MountainList.this, Output2.class);

                        startActivity(intent);
                    }  else if (position == 3) {
                        Intent intent = new Intent(MountainList.this, Output3.class);

                        startActivity(intent);
                    }  else if (position == 4)  {
                        Intent intent = new Intent(MountainList.this, Output4.class);

                        startActivity(intent);
                    }


                }

            }

        });


    }

    protected class JSONWeatherTask extends AsyncTask<String, Void, Weather> {

        @Override
        protected Weather doInBackground(String... params) {
            //Weather weather = new Weather();
            String data = ((new WeatherHttpClient()).getWeatherData(params[0]));

            //try {

            Weather weather = new Weather();
            try {
                weather = JSONWeatherParser.getWeatherData(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            // Let's retrieve the icon
            //weather.iconData = ((new Output())).getImage(weather.currentCondition.getIcon());

            //} catch (JSONException e) {
            //e.printStackTrace();
            //}
            return weather;

        }


        @Override
        protected void onPostExecute(Weather weather) {
            imgView1 = (ImageView)findViewById(R.id.condIcon);
            textView11 = (TextView)findViewById(R.id.text11);
            // Let's retrieve the icon
            //weather.iconData = ((new Output())).getImage(weather.currentCondition.getIcon());
            super.onPostExecute(weather);

            if (weather.iconData != null && weather.iconData.length > 0) {
                Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
                imgView.setImageBitmap(img);
            }

            cityText.setText(weather.location.getCity() + "," + weather.location.getCountry());
            condDescr.setText(weather.currentCondition.getCondition());
            textView11.setText(weather.currentCondition.getIcon());
            if(weather.currentCondition.getIcon().equals("50d") || weather.currentCondition.getIcon().equals("50n"))
            {
                imgView1.setImageResource(R.drawable.fifty);
            } else if(weather.currentCondition.getIcon().equals("13d") || weather.currentCondition.getIcon().equals("13n"))
            {
                imgView1.setImageResource(R.drawable.thirteen);
            }  else if(weather.currentCondition.getIcon().equals("11d") || weather.currentCondition.getIcon().equals("11n"))
            {
                imgView1.setImageResource(R.drawable.eleven);
            } else if(weather.currentCondition.getIcon().equals("10d")) {
                imgView1.setImageResource(R.drawable.ten);
            } else if(weather.currentCondition.getIcon().equals("10n")) {
                imgView1.setImageResource(R.drawable.ten);
            } else if(weather.currentCondition.getIcon().equals("09d") || weather.currentCondition.getIcon().equals("09n"))
            {
                imgView1.setImageResource(R.drawable.nine);
            } else if(weather.currentCondition.getIcon().equals("04n") || weather.currentCondition.getIcon().equals("04d"))
            {
                imgView1.setImageResource(R.drawable.four);
            } else if(weather.currentCondition.getIcon().equals("03n") || weather.currentCondition.getIcon().equals("03d"))
            {
                imgView1.setImageResource(R.drawable.three);
            }  else if(weather.currentCondition.getIcon().equals("02n")) {
                imgView1.setImageResource(R.drawable.two);
            } else if(weather.currentCondition.getIcon().equals("02d")) {
                imgView1.setImageResource(R.drawable.two);
            } else if(weather.currentCondition.getIcon().equals("01d")) {
                imgView1.setImageResource(R.drawable.one);
            } else if(weather.currentCondition.getIcon().equals("01n")) {
                imgView1.setImageResource(R.drawable.one);
            }

            //      if(weather.currentCondition.getCondition().equals("Haze"))
            //      {
            //          imgView1.setImageResource(R.drawable.myimg50d);
            //      }
            temp.setText("" + Math.round((weather.temperature.getTemp() - 273.15)) + "°C");
            //hum.setText("" + weather.currentCondition.getHumidity() + "%");
            //press.setText("" + weather.currentCondition.getPressure() + " hPa");
            //windSpeed.setText("" + weather.wind.getSpeed() + " mps");
            //windDeg.setText("" + weather.wind.getDeg() + "°");

        }


    }

    protected class JSONForecastWeatherTask extends AsyncTask<String, Void, WeatherForecast> {

        @Override
        protected WeatherForecast doInBackground(String... params) {

            String data = ((new WeatherHttpClient()).getForecastWeatherData(params[0], params[1], params[2]));
            WeatherForecast forecast = new WeatherForecast();
            try {
                forecast = JSONWeatherParser.getForecastWeather(data);
                System.out.println("Weather [" + forecast + "]");
                // Let's retrieve the icon
                //weather.iconData = ( (new WeatherHttpClient()).getImage(weather.currentCondition.getIcon()));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return forecast;

        }


        @Override
        protected void onPostExecute(WeatherForecast forecastWeather) {
            // Let's retrieve the icon
            //forecast.iconData = ((new Output())).getImage(weather.currentCondition.getIcon());
            super.onPostExecute(forecastWeather);

            DailyForecastPageAdapter adapter = new DailyForecastPageAdapter(Integer.parseInt(forecastDaysNum), getSupportFragmentManager(), forecastWeather);

            pager.setAdapter(adapter);
        }
    }

}
