package de.bonding.hackathon.eighthundredtwelvers;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by csontag on 11/18/16.
 */
public class AlarmActivity extends AppCompatActivity {

    protected Ringtone ringtone = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        ringtone = RingtoneManager.getRingtone(this.getBaseContext(), alarmUri);
        ringtone.play();

        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        TextView time = (TextView) this.findViewById(R.id.activity_alarm_time);
        time.setText(d.getHours() + ":" + d.getMinutes());

        TextView status = (TextView) this.findViewById(R.id.activity_alarm_status);
        status.setText("Rainy, 10° C");

        Button b = (Button) this.findViewById(R.id.activity_alarm_stop);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ringtone.stop();
                finish();
            }
        });

    }



}
