
package com.example.benjamin.snowday;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpClient {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?"; //current weather
    //private static String BASE_FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast?q="; //forecast weather
    private static String BASE_FORECAST_URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&"; //forecast weather
    private static String IMG_URL = "http://openweathermap.org/img/w/";


    public String getWeatherData(String location) {
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + location)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (  (line = br.readLine()) != null )
                buffer.append(line + "\r\n");

            is.close();
            con.disconnect();
            return buffer.toString();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }

        return null;

    }

    public String getForecastWeatherData(String location, String lang, String sForecastDayNum) {
        HttpURLConnection con = null;
        InputStream is = null;
        int forecastDayNum = Integer.parseInt(sForecastDayNum);

        try {

            // Forecast
            String url = BASE_FORECAST_URL + location;
            if (lang != null)
                url = url + "&lang=" + lang;

            url = url + "&cnt=" + forecastDayNum;
            con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            StringBuffer buffer1 = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br1 = new BufferedReader(new InputStreamReader(is));
            String line1 = null;
            while ((line1 = br1.readLine()) != null)
                buffer1.append(line1 + "\r\n");

            is.close();
            con.disconnect();

            System.out.println("Buffer [" + buffer1.toString() + "]");
            return buffer1.toString();
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Throwable t) {
            }
            try {
                con.disconnect();
            } catch (Throwable t) {
            }
        }

        return null;

    }

    /*public byte[] getImage(String code) {
        Log.v("Myapp",code);
        /*HttpURLConnection con = null ;
        InputStream is = null;
        try {
            con = (HttpURLConnection) ( new URL(IMG_URL + code + ".png")).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            //con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ( is.read(buffer) != -1)
                baos.write(buffer);

            return baos.toByteArray();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bitmap;
        Context context = Output.getContextResources();
        String imgCode = code.toString();
        switch (imgCode){
            case "01d":
                bitmap = BitmapFactory.decodeResource(clientContext.getResources(), R.drawable.myimg01d);
                break;
            case "02d":
                bitmap = BitmapFactory.decodeResource(, R.drawable.myimg02d);
                break;
            case "03d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg03d);
                break;
            case "04d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg04d);
                break;
            case "09d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg09d);
                break;
            case "10d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg10d);
                break;
            case "11d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg11d);
                break;
            case "13d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg13d);
                break;
            case "50d":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg50d);
                break;
            case "01n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg01n);
                break;
            case "02n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg02n);
                break;
            case "03n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg03n);
                break;
            case "04n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg04n);
                break;
            case "09n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg09n);
                break;
            case "10n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg10n);
                break;
            case "11n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg11n);
                break;
            case "13n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg13n);
                break;
            case "50n":
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg50n);
                break;
            default:
                bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.myimg01d);
                break;
        }

        bitmap.compress(Bitmap.CompressFormat.PNG, 70, stream);
        return stream.toByteArray();


    }*/


}

