package de.bonding.hackathon.eighthundredtwelvers;

import android.content.Context;
import android.util.Log;

import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

import static de.bonding.hackathon.eighthundredtwelvers.BuildConfig.OWM_API_KEY;

/**
 * Created by Sascha on 18.11.2016.
 */

public class WeatherAtMoment {
    //Weather_magnitudes werte =

    public void updateWeather(Context context) {
        WeatherMap weatherMap;
       weatherMap = new WeatherMap(context, OWM_API_KEY);

        weatherMap.getCityWeather("Braunschweig", new WeatherCallback() {
            @Override
            public void success(WeatherResponseModel response) {
                github.vatsal.easyweather.retrofit.models.Weather weather[] = response.getWeather();
                String weatherMain = weather[0].getMain();

                Double temperature = TempUnitConverter.convertToCelsius(response.getMain().getTemp());

                String location = response.getName();
                String humidity= response.getMain().getHumidity();
                String pressure = response.getMain().getPressure();
                String windSpeed = response.getWind().getSpeed();
                String iconLink = weather[0].getIconLink();

                Log.e("temperature", String.valueOf(temperature));
                Log.e("Location", location);
                Log.e("Humidity", humidity);
                Log.e("pressure", pressure);
                Log.e("windSpeed", windSpeed);
                Log.e("iconLink", iconLink);
                Log.e("weather", weatherMain);
                Log.e("weather[0]", weather[0].toString());

            }
            @Override
            public void failure(String message) {
                Log.e("GetCityWeather", "failure");
            }
        });
    }





}
