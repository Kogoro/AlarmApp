package de.bonding.hackathon.eighthundredtwelvers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import de.bonding.hackathon.eighthundredtwelvers.model.Alarm;
import de.bonding.hackathon.eighthundredtwelvers.model.Rule;

public class EditAlarm extends AppCompatActivity {

    private EditText nameET;
    private EditText timeET;
    private Spinner ruleS;
    private Button makeAlarmBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_edit_alarm);
        nameET = (EditText) findViewById(R.id.alarmnameET);
        timeET = (EditText) findViewById(R.id.timeET);
        ruleS = (Spinner) findViewById(R.id.ruleS);
        ArrayAdapter<Rule> ad = new ArrayAdapter<Rule>(this, R.layout.support_simple_spinner_dropdown_item);
        ad.addAll(Rule.getDummy());
        ruleS.setAdapter(ad);
        makeAlarmBTN = (Button) findViewById(R.id.makeAlarmBTN);
        makeAlarmBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeAlarm();
            }
        });
    }

    private void makeAlarm() {
        String name = nameET.getText().toString();
        String timestring = timeET.getText().toString();
        DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        Date date;
        try {
            date = formatter.parse(timestring);
        } catch (ParseException e) {
            date = new Date(System.currentTimeMillis());
            e.printStackTrace();
        }
        Calendar now = Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, now.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, now.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_YEAR, now.get(Calendar.DAY_OF_YEAR) + 1);
        long time = calendar.getTimeInMillis();
        Rule r = (Rule) ruleS.getSelectedItem();
        Alarm a = new Alarm();
        a.name = name;
        a.status = false;
        a.time = time;
        a.rule = r;
        a.insert();
        finish();
    }

}
