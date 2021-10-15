package com.example.demointents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class AlarmClockDemoActivity extends AppCompatActivity {

    EditText hourEditText, minuteEditText, messageEditText;
    Button setTimeButton, setAlarmButton;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour, currentMinute;

    private TimePickerDialog.OnTimeSetListener timePickerDialogHelper = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
            hourEditText.setText(String.format("%02d", hourOfDay));
            minuteEditText.setText(String.format("%02d", minutes));
        }
    };

    private View.OnClickListener setTimeHelper = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            calendar = Calendar.getInstance();
            currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            currentMinute = calendar.get(Calendar.MINUTE);

            timePickerDialog = new TimePickerDialog(AlarmClockDemoActivity.this, timePickerDialogHelper, currentHour, currentMinute, false);

            timePickerDialog.show();
        }
    };

    private View.OnClickListener setAlarmHelper = new View.OnClickListener() {

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
                    Log.e("MainActivity", "No Alarm Clock");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_clock_demo);

        hourEditText = (EditText) findViewById(R.id.hhEditText);
        minuteEditText = (EditText) findViewById(R.id.mmEditText);
        messageEditText= (EditText) findViewById(R.id.msgEditText);
        setTimeButton = (Button) findViewById(R.id.setTimeButton);
        setAlarmButton =  (Button) findViewById(R.id.setAlarmButton);

        setTimeButton.setOnClickListener(setTimeHelper);
        setAlarmButton.setOnClickListener(setAlarmHelper);
    }
}