package com.example.listviewweek4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateListViewContent();
    }

    private void populateListViewContent() {
        ListView listView = (ListView) findViewById(R.id.idListView);

        ArrayList<facultyDataItem> facultyDataItems = new ArrayList<>();
        facultyDataItems.add(new facultyDataItem("Faculty of Information Technology", "https://www.fit.hcmus.edu.vn","+84-28-383542"));
        facultyDataItems.add(new facultyDataItem("Faculty of Mathematics & Informatics", "https://www.math.hcmus.edu.vn","+84-28"));

        facultyAdapter facultyAdapter = new facultyAdapter(this, facultyDataItems);

        listView.setAdapter(facultyAdapter);
    }


}