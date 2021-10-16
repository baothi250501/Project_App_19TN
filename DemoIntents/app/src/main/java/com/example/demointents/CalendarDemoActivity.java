package com.example.demointents;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalendarDemoActivity extends AppCompatActivity {

    private EditText title;
    private EditText description;
    private EditText location;

    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_demo);

        title = findViewById(R.id.titleEditText);
        description = findViewById(R.id.dctEditText);
        location = findViewById(R.id.locationEditText);
        Button setEventBtn = findViewById(R.id.setEventButton);

        setEventBtn.setOnClickListener(view -> {
            if (!title.getText().toString().isEmpty()){
                if (location.getText().toString().isEmpty()){
                    location.setText("");
                }
                if (description.getText().toString().isEmpty()){
                    description.setText("");
                }

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, title.getText().toString());
                intent.putExtra(CalendarContract.Events.DESCRIPTION, description.getText().toString());
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());

                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                } else {
                    Toast.makeText(CalendarDemoActivity.this, "No support Calendar Intent",Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(CalendarDemoActivity.this, "Please fill info of event",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
