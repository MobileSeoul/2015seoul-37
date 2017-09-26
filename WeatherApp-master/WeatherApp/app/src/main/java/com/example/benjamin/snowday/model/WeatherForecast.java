package com.example.benjamin.snowday.model;

/**
 * Created by BU on 4/21/15.
 */

import java.util.ArrayList;
import java.util.List;

public class WeatherForecast {

        private List<DayForecast> daysForecast = new ArrayList<DayForecast>();

        public void addForecast(DayForecast forecast) {
            daysForecast.add(forecast);
            System.out.println("Add forecast ["+forecast+"]");
        }

        public DayForecast getForecast(int dayNum) {
            return daysForecast.get(dayNum);
        }
}

