package de.bonding.hackathon.eighthundredtwelvers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;

import java.util.List;

import de.bonding.hackathon.eighthundredtwelvers.model.Alarm;

public class AlarmService extends Service {

    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    public AlarmService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        updateService();
        return null;
    }

    public void updateService() {
        List<Alarm> alarms = Alarm.getAll();

        Alarm min = null;

        for(Alarm a : alarms) {
            if (min == null) {
                min = a;
            } else {
                if (a.time < min.time)
                    min = a;
            }
        }
        alarmMgr = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);

        Intent intentBroadcast = new Intent(getApplicationContext(), AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, intentBroadcast, 0);

        alarmMgr.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() +
                        60 * 1000, alarmIntent);
    }
}
