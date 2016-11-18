package de.bonding.hackathon.eighthundredtwelvers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, new RuleFragment()).commit();
    }
}
