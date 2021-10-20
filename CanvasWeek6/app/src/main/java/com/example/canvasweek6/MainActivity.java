package com.example.canvasweek6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignColor2Buttons();
    }

    private void assignColor2Buttons() {
        assignColor2Buttons(R.id.buttonRed, 255, 0, 0);
        assignColor2Buttons(R.id.buttonBlue,0, 0, 255);
        assignColor2Buttons(R.id.buttonGreen,0, 255, 0);
    }

    private void assignColor2Buttons(int idButton, int r, int g, int b) {
        ImageButton btn = (ImageButton) findViewById(idButton);
        Bitmap bmp = createBitmapForButton(64, 64, r, g, b);
        btn.setImageBitmap(bmp);
    }

    private Bitmap createBitmapForButton(int w, int h, int r, int g, int b) {
        Bitmap bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawRGB(r, g, b);
        return bmp;
    }

    public void prepareImageView(View view) {
        initRandomContentForImageView();
    }

    private void initRandomContentForImageView() {
        Bitmap bmpContent = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmpContent);

        canvas.drawRGB(59, 112, 168);

        ImageView imageView = (ImageView) findViewById(R.id.imageViewMain);
        imageView.setImageBitmap(bmpContent);

        imageView.invalidate();

    }
}