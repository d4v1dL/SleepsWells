package com.example.sleepswell;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;

import com.example.sleepswell.ui.Alarme.AlarmReceiver;
import com.example.sleepswell.ui.Alarme.despertador;

public class ClasseCancelaAlarme extends despertador {

    private final int notificationId = 1;

    public void CancelaBotao() {
        Intent intent = new Intent(ClasseCancelaAlarme.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                ClasseCancelaAlarme.this,0,intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(alarmIntent);
        Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show();
    }
}
