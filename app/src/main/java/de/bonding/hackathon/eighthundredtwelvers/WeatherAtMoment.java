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



    public void updateWeather(Context context, String latitude, String longitude) {
        WeatherMap weatherMap;
       weatherMap = new WeatherMap(context, OWM_API_KEY);

        weatherMap.getLocationWeather(latitude, longitude, new WeatherCallback() {
            @Override
            public void success(WeatherResponseModel response) {
                github.vatsal.easyweather.retrofit.models.Weather weather[] = response.getWeather();


                Double temperature = TempUnitConverter.convertToCelsius(response.getMain().getTemp());

                String weatherMain = weather[0].getMain();
                String location = response.getName();
                String humidity= response.getMain().getHumidity();
                String pressure = response.getMain().getPressure();
                String windSpeed = response.getWind().getSpeed();
                String iconLink = weather[0].getIconLink();


                WeatherMagnitudes.WEATHER.setValue(weatherMain);
                WeatherMagnitudes.LOCATION.setValue(location);
                WeatherMagnitudes.HUMIDITY.setValue(humidity);
                WeatherMagnitudes.PRESSURE.setValue(pressure);
                WeatherMagnitudes.WINDSPEED.setValue(windSpeed);
                WeatherMagnitudes.TEMPERATURE.setValue(temperature.toString());



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
