package com.example.week5app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onShapeSelection(View view) {
        int id = view.getId();
        switch (id){
            case R.id.buttonLine:
                MyGlobal.ShapeSelection = "Line";
                break;
            case R.id.buttonRectangle:
                MyGlobal.ShapeSelection = "Rectangle";
                break;
            case R.id.buttonElipse:
                MyGlobal.ShapeSelection = "Elipse";
                break;

        }
    }

    public void onColorSelection(View view) {
        selectColor();
    }

    private void selectColor() {
        Random random = new Random();
        MyGlobal.ColorSelection = shape.encodeColor(255,
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
    }
}