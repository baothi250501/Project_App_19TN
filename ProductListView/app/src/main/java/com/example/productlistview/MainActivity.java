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
        productDataItems.add(new penCaseDataItem("Canvas Pop-up case", "Brown","1 main tray, 3 small tray","12.5 - 18.5 cm",R.drawable.pencase1));
        productDataItems.add(new handbookDataItem("Cornell Ruled", "Red", "Line", 120, "183x260 mm", R.drawable.handbook2));
        productDataItems.add(new penCaseDataItem("Aineeba Big Capacity pen case", "Pink Pastel","1 main tray","18 - 25 cm",R.drawable.pencase2));
        productDataItems.add(new handbookDataItem("Coffeeine Espresso Notebook", "Latte","Dot", 180,"145x208 mm",R.drawable.handbook3));
        productDataItems.add(new penCaseDataItem("Canvas Double Pen Case", "Blue","1 main tray, 4 small tray","15 - 21.5 cm",R.drawable.pencase3));
        productDataItems.add(new handbookDataItem("Be Black Notebook", "Black","Dotgrid", 112,"145x208 mm",R.drawable.handbook4));

        productAdapter productAdapter = new productAdapter(this, productDataItems);

        listView.setAdapter(productAdapter);
    }


}