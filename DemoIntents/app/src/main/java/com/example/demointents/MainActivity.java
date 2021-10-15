package com.example.demointents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the content of activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find the View that shows the alarm clock demo
        TextView alarmClockDemo = (TextView)findViewById(R.id.alarmClockDemo);

        //Set a clickListener on that View
        alarmClockDemo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link AlarmClockDemoActivity}
                Intent alarmClockIntent = new Intent(MainActivity.this, AlarmClockDemoActivity.class);

                //Start the new activity
                startActivity(alarmClockIntent);
            }

        });

        //Find the View that shows the calendar demo
        TextView calendarDemo = (TextView)findViewById(R.id.calendarDemo);

        //Set a clickListener on that View
        calendarDemo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link CalendarDemoActivity}
                Intent calendarIntent = new Intent(MainActivity.this, CalendarDemoActivity.class);

                //Start the new activity
                startActivity(calendarIntent);
            }

        });

        //Find the View that shows the camera demo
        TextView cameraDemo = (TextView)findViewById(R.id.cameraDemo);

        //Set a clickListener on that View
        cameraDemo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                //Create a new intent to open the {@link CameraDemoActivity}
                Intent cameraIntent = new Intent(MainActivity.this, CameraDemoActivity.class);

                //Start the new activity
                startActivity(cameraIntent);
            }

        });

    }

}