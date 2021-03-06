package de.bonding.hackathon.eighthundredtwelvers;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

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
                Intent i = new Intent(this, EditAlarm.class);
                startActivity(i);
                break;
            case R.id.goToRules:
                Intent i2 = new Intent(this, RuleActivity.class);
                startActivity(i2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
