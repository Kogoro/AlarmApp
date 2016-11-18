package de.bonding.hackathon.eighthundredtwelvers;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, OverviewFragment.newInstance()).commit();
        toolbar = getSupportActionBar();
        WeatherAtMoment w = new WeatherAtMoment();
        w.updateWeather(this, "55", "55");
    }

    private void openRuleFragment() {
        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new RuleFragment()).commit();
    }
}
