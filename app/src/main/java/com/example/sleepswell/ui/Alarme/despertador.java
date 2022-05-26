package com.example.sleepswell.ui.Alarme;


import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sleepswell.R;
import com.example.sleepswell.bottom_navigation;
import java.util.Calendar;
import java.util.Locale;


public class despertador extends AppCompatActivity{

    private TextView textHora;
    int hora, minuto;

    private final int notificationId = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despertador);

        Button buttonIniciar = findViewById(R.id.buttonIniciar);
        Button buttonCancelar = findViewById(R.id.buttonCancelar);
        Button buttonVoltar = findViewById(R.id.buttonVoltar);
        textHora = findViewById(R.id.textHour);


        //voltar para o bottom navigation
        buttonVoltar.setOnClickListener(v ->  {

            Intent janelaAlarme = new Intent(getApplicationContext(), bottom_navigation.class );
            startActivity(janelaAlarme);
        });

        //setar o botão para abrir o time picker
      buttonIniciar.setOnClickListener(this::popTimePicker);


     buttonCancelar.setOnClickListener(v -> CancelaBotao());
    }


    //abre o time picker
   public void popTimePicker(View view){

        TimePickerDialog.OnTimeSetListener onTimeSetListener = (view1, selectedHour, selectedMinute) -> {
             hora = selectedHour;
             minuto = selectedMinute;
             textHora.setText(String.format(Locale.getDefault(), "%02d:%02d", hora, minuto));
             Log.d("visao", (hora + ":" + minuto));
                IniciaBotao();

        };


        int style = AlertDialog.THEME_HOLO_LIGHT;

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, style, onTimeSetListener, hora, minuto, true);
        timePickerDialog.setTitle("Escolha hora");
        timePickerDialog.show();
    }




    public void IniciaBotao(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(despertador.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                despertador.this,0,intent, PendingIntent.FLAG_CANCEL_CURRENT
        );

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hora);
        calendar.set(Calendar.MINUTE, minuto);
        calendar.set(Calendar.SECOND, 0 );
        Log.d("visao2", (hora + ":" + minuto));
        long alarmStartTime = calendar.getTimeInMillis();

        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
        Toast.makeText(this, "Iniciado", Toast.LENGTH_SHORT).show();

    }




    public void CancelaBotao(){
        Intent intent = new Intent(despertador.this, AlarmReceiver.class);
        intent.putExtra("notificationId", notificationId);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(
                despertador.this,0,intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.cancel(alarmIntent);
        Toast.makeText(this,"Cancelado", Toast.LENGTH_SHORT).show();

    }
}











