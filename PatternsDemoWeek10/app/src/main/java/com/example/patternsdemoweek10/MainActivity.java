package com.example.patternsdemoweek10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyFlexibleObject phanso = new MyFlexibleObject();
        MyFlexibleObject sinhVien = new MyFlexibleObject();
        MyFlexibleObject phanSo1 = new MyFlexibleObject("PhanSo");

        phanso.setAttributeValue("Tu so", 1);
        phanso.setAttributeValue("Mau so", 2);
    }
}