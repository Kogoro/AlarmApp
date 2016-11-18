package de.bonding.hackathon.eighthundredtwelvers;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.Weather;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

import static de.bonding.hackathon.eighthundredtwelvers.BuildConfig.OWM_API_KEY;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.setTitle(R.string.app_name);

        fm = this.getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.main_fragment, OverviewFragment.newInstance()).commit();

        WeatherAtMoment w = new WeatherAtMoment();
        w.updateWeather(this, "55", "55");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.addAlarm:
                //Intent i = new Intent(this, )
                //startActivity(i);
                break;
            case R.id.goToRules:
                fm.beginTransaction().replace(R.id.main_fragment, new RuleFragment());
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
