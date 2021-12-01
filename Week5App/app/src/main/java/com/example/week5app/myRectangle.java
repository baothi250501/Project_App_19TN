package com.example.week5app;

import android.graphics.Canvas;
import android.graphics.Paint;

public class myRectangle extends shape {
    public void draw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.brushColor) ;
        paint.setStrokeWidth(30);
        canvas.drawRect(P1.x, P1.y, P2.x, P2.y, paint);

        //super.draw(canvas);
    }
}
