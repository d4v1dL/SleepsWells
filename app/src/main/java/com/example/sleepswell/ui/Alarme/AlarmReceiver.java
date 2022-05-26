package com.example.sleepswell.ui.Alarme;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.example.sleepswell.ui.Alarme.despertador;

public class AlarmReceiver extends BroadcastReceiver {


    private static final String CHANNEL_ID = "SAMPLE_CHANNEL" ;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String USE_FULL_SCREEN_INTENT = "android.permission.USE_FULL_SCREEN_INTENT";



    @Override
    public void onReceive(Context context, Intent intent) {

        //get id & messege from intent
        int notificationId = intent.getIntExtra("notificationId",0);

        //estende a notificação
        Intent fullScreenIntent = new Intent(context, despertador.class);
        PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(context, 0,
                fullScreenIntent, PendingIntent.FLAG_UPDATE_CURRENT);




        //chama despertador quando clica na notificação.
        Intent mainIntente = new Intent(context, despertador.class);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context, 0, mainIntente,0
        );

        //notificationManager
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            //Para API 26 e posteriores
            CharSequence channel_name = "My notification";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channel_name, importance);
            notificationManager.createNotificationChannel(channel);
        }



         // preparando notificações
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Sleeps Well")
                .setContentText(" Alarme!!! ")
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Alarme!!!") )
                .setContentIntent(contentIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setFullScreenIntent(fullScreenPendingIntent, true)


                .setAutoCancel(true);

        //Notificando
        notificationManager.notify(notificationId, builder.build());
        tocarMusica();
    }

    public void tocarMusica(){


    }


}
