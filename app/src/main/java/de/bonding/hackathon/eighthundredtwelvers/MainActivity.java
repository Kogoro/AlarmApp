package de.bonding.hackathon.eighthundredtwelvers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.Weather;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

import static de.bonding.hackathon.eighthundredtwelvers.BuildConfig.OWM_API_KEY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, OverviewFragment.newInstance()).commit();

        WeatherAtMoment w = new WeatherAtMoment();
        w.updateWeather(this, "55", "55");



    }
}
