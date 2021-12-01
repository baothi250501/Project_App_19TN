package com.example.week5app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPickerView extends View {
    private Bitmap bmp;

    public ColorPickerView(Context context){
        super(context);
    }
    public ColorPickerView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        if (bmp == null)
            bmp = BitmapFactory.decodeResource(
                    getResources(),
                    R.drawable.colorcollection);
        canvas.drawBitmap(bmp, 0, 0, new Paint());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // get masked (not specific to a pointer) action
        int maskedAction = event.getActionMasked();
        float x = event.getX();
        float y = event.getY();

        switch (maskedAction) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_UP: {
                // TODO use data
                getColorAtLocation(x,y);
                break;
            }

        }
        return super.onTouchEvent(event);
    }

    private void getColorAtLocation(float x, float y) {
        if (x <bmp.getWidth())
            MyGlobal.ColorSelection = bmp.getPixel((int)x, (int)y);
    }
}
