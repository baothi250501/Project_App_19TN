package com.example.demointents;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmClockDemoActivity extends AppCompatActivity {

    private EditText hourEditText, minuteEditText, messageEditText;
    int currentHour, currentMinute;

    private final TimePickerDialog.OnTimeSetListener timePickerDialogHelper = new TimePickerDialog.OnTimeSetListener(){
        @SuppressLint("DefaultLocale")
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
            hourEditText.setText(String.format("%02d", hourOfDay));
            minuteEditText.setText(String.format("%02d", minutes));
        }
    };

    private final View.OnClickListener setTimeHelper = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calendar calendar = Calendar.getInstance();
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(AlarmClockDemoActivity.this, timePickerDialogHelper, currentHour, currentMinute, false);

            timePickerDialog.show();
        }
    };

    private final View.OnClickListener setAlarmHelper = new View.OnClickListener() {

        @SuppressLint({"SetTextI18n", "QueryPermissionsNeeded"})
        @Override
        public void onClick(View view) {
            if (messageEditText.getText().toString().isEmpty()){
                messageEditText.setText("Busy Work");
            }
            if (!hourEditText.getText().toString().isEmpty() && !minuteEditText.getText().toString().isEmpty()) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hourEditText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minuteEditText.getText().toString()));
                intent.putExtra(AlarmClock.EXTRA_MESSAGE, messageEditText.getText().toString());
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(AlarmClockDemoActivity.this, "No support Alarm Clock Intent",Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock_demo);

        hourEditText = findViewById(R.id.hhEditText);
        minuteEditText = findViewById(R.id.mmEditText);
        messageEditText= findViewById(R.id.msgEditText);
        Button setTimeButton = findViewById(R.id.setTimeButton);
        Button setAlarmButton = findViewById(R.id.setAlarmButton);

        setTimeButton.setOnClickListener(setTimeHelper);
        setAlarmButton.setOnClickListener(setAlarmHelper);
    }
}
