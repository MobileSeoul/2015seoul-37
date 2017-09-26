package com.example.benjamin.snowday;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benjamin.snowday.adapter.DailyForecastPageAdapter;
import com.example.benjamin.snowday.model.Weather;
import com.example.benjamin.snowday.model.WeatherForecast;

import org.json.JSONException;

//import com.example.benjamin.snowday.model.Location;

public class MainActivity extends FragmentActivity {
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
   // protected EditText locationString;p
    protected TextView highlow;


    private static String forecastDaysNum = "7";
    protected ViewPager pager;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
   //   ActionBar ab = getActionBar();
   //   ab.setHomeButtonEnabled(false);
   //     ab.setDisplayHomeAsUpEnabled(false);
   //   ab.hide();

        searchButton = (Button) findViewById(R.id.go_button);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void search(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Output.class);
    //    locationString = (EditText) findViewById(R.id.location_entry);
    //    String message = locationString.getText().toString();
    //    intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
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



            return weather;

        }


        @Override
        protected void onPostExecute(Weather weather) {
            imgView1 = (ImageView)findViewById(R.id.condIcon);
            textView11 = (TextView)findViewById(R.id.text11);
            highlow = (TextView)findViewById(R.id.highlow);
            // Let's retrieve the icon
            //weather.iconData = ((new Output())).getImage(weather.currentCondition.getIcon());
            super.onPostExecute(weather);

            if (weather.iconData != null && weather.iconData.length > 0) {
                Bitmap img = BitmapFactory.decodeByteArray(weather.iconData, 0, weather.iconData.length);
                imgView.setImageBitmap(img);
            }
            highlow.setText( "High: "+(int) (weather.temperature.getMaxTemp() - 273.15) +"°C" + "\nLow: " + (int) (weather.temperature.getMinTemp() - 273.15) +"°C" );
            cityText.setText(weather.location.getCity());
            if(weather.location.getCity().toString().contains("Vijongbu"))
            {
                cityText.setText("수락산");
            } else if(weather.location.getCity().toString().contains("Kuri")) {
                cityText.setText("불암산");
            } else if(weather.location.getCity().toString().contains("Wonteo")) {
                cityText.setText("청계산");
            } else if(weather.location.getCity().toString().contains("ungnap-tong")) {
                cityText.setText("아차산");
            } else if(weather.location.getCity().toString().contains("Seoul")) {
                cityText.setText("북한산");
            }
            condDescr.setText(weather.currentCondition.getCondition());
            if(weather.currentCondition.getCondition().toString().contains("Clear"))
            {
                condDescr.setText("맑음");
            } else if(weather.currentCondition.getCondition().toString().contains("Clouds"))
            {
                condDescr.setText("흐림");
            }  else if(weather.currentCondition.getCondition().toString().contains("Haze"))
            {
                condDescr.setText("안개");
            }
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