package com.example.week5app;

import android.graphics.Canvas;
import android.graphics.Paint;

public class myLine extends shape {
    @Override
    public void draw(Canvas canvas) {
        //super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(this.penColor);
        paint.setStrokeWidth(10);
        canvas.drawLine(P1.x, P1.y, P2.x, P2.y, paint);
    }
}
