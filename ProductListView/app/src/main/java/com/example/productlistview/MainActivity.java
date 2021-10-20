package com.example.productlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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

        ArrayList<productDataItem> productDataItems = new ArrayList<>();
        productDataItems.add(new handbookDataItem("Baked & Fun Dotted Notebook", "Green","Dotgrid", 180,"A5",R.drawable.handbook1));
        productDataItems.add(new penCaseDataItem("Pop-up case", "Pink Pastel","1 main tray, 3 small tray","12.5 - 18.5 cm",R.drawable.pencase1));

        productAdapter productAdapter = new productAdapter(this, productDataItems);

        listView.setAdapter(productAdapter);
    }


}