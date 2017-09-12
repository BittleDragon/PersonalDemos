package com.rxt.timeschedulesample;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @butterknife.BindView(R.id.start_alarm)
    Button startAlarm;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);

    }

    @butterknife.OnClick(R.id.start_alarm)
    public void onViewClicked() {
        intent = new Intent(this, AlarmTaskService.class);
        PendingIntent pendingIntent = PendingIntent.getService
                (this, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long alarmTime = SystemClock.elapsedRealtime() + 5 * 1000;
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, alarmTime, pendingIntent);
        Log.e("设置定时任务", "执行了");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }
}
