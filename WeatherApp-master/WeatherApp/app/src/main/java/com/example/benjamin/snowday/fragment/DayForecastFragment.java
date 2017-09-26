package com.example.benjamin.snowday.fragment;

/**
 * Created by BU on 4/21/15.
 */

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benjamin.snowday.R;
import com.example.benjamin.snowday.model.DayForecast;

public class DayForecastFragment extends Fragment{

        private DayForecast dayForecast;
        private ImageView imageView2;
        private TextView textview22;

        public DayForecastFragment() {}

        public void setForecast(DayForecast dayForecast) {

            this.dayForecast = dayForecast;

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.dayforecast_fragment, container, false);
            imageView2 = (ImageView)v.findViewById(R.id.descView);
            TextView tempView = (TextView) v.findViewById(R.id.tempForecast);
            TextView descView = (TextView) v.findViewById(R.id.skydescForecast);
            textview22 = (TextView) v.findViewById(R.id.text22);
            tempView.setText( "High: "+(int) (dayForecast.forecastTemp.max - 273.15) +"°C" + "\nLow: " + (int) (dayForecast.forecastTemp.min - 273.15) +"°C" );
            descView.setText(dayForecast.weather.currentCondition.getDescr());
            if(dayForecast.weather.currentCondition.getDescr().toString().contains("clouds"))
            {
                descView.setText("흐림");
            } else if(dayForecast.weather.currentCondition.getDescr().toString().contains("clear"))
            {
                descView.setText("맑음");
            } else if(dayForecast.weather.currentCondition.getDescr().toString().contains("rain"))
            {
                descView.setText("비");
            }
            textview22.setText(dayForecast.weather.currentCondition.getIcon());
            if(dayForecast.weather.currentCondition.getIcon().equals("50d") || dayForecast.weather.currentCondition.getIcon().equals("50n"))
            {
                imageView2.setImageResource(R.drawable.fifty);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("13d") || dayForecast.weather.currentCondition.getIcon().equals("13n"))
            {
                imageView2.setImageResource(R.drawable.thirteen);
            }  else if(dayForecast.weather.currentCondition.getIcon().equals("11d") || dayForecast.weather.currentCondition.getIcon().equals("11n"))
            {
                imageView2.setImageResource(R.drawable.eleven);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("10d")) {
                imageView2.setImageResource(R.drawable.ten);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("10n")) {
                imageView2.setImageResource(R.drawable.ten);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("09d") || dayForecast.weather.currentCondition.getIcon().equals("9n"))
            {
                imageView2.setImageResource(R.drawable.nine);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("04n") || dayForecast.weather.currentCondition.getIcon().equals("04d"))
            {
                imageView2.setImageResource(R.drawable.four);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("03n") || dayForecast.weather.currentCondition.getIcon().equals("03d"))
            {
                imageView2.setImageResource(R.drawable.three);
            }  else if(dayForecast.weather.currentCondition.getIcon().equals("02n")) {
                imageView2.setImageResource(R.drawable.two);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("02d")) {
                imageView2.setImageResource(R.drawable.two);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("01d")) {
                imageView2.setImageResource(R.drawable.one);
            } else if(dayForecast.weather.currentCondition.getIcon().equals("01n")) {
                imageView2.setImageResource(R.drawable.one);
            }
         //  if(dayForecast.weather.currentCondition.getDescr().equals("overcast clouds"))
          //  {
          //      imageView2.setImageResource(R.drawable.myimg04d);
          //  }

            // Now we retrieve the weather icon
            JSONIconWeatherTask task = new JSONIconWeatherTask();
            task.execute(new String[]{dayForecast.weather.currentCondition.getIcon()});

            return v;
        }



        private class JSONIconWeatherTask extends AsyncTask<String, Void, byte[]> {

            @Override
            protected byte[] doInBackground(String... params) {

                byte[] data = null;

                try {

                    // Let's retrieve the icon
                   // ((new Output())).getImage(weather.currentCondition.getIcon());
                   // data = ( (new Output()).getImage(params[0]));

                } catch (Exception e) {
                    e.printStackTrace();
                }

                return data;
            }




            @Override
            protected void onPostExecute(byte[] data) {
                super.onPostExecute(data);


                }
            }



        }



