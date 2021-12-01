package com.example.week5app;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myPaintView extends View {
    private boolean bDraw = false;

    public myPaintView(Context context){
        super(context);
        initTempLine();
    }

    private void initTempLine(){
        shape obj = new myLine();
        obj.P1 = new Point(0, 0);
        obj.P2 = new Point(100, 200);
        shapes.add(obj);
    }

    public myPaintView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        initTempLine();
    }

    private ArrayList<shape> shapes = new ArrayList<shape>();

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        canvas.drawARGB(255, 255, 255, 255);
        for (int i = 0; i < shapes.size(); ++i){
            shapes.get(i).draw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //return super.onTouchEvent(event);
        // get pointer index from the event object
        //int pointerIndex = event.getActionIndex();

        // get pointer ID
        //int pointerId = event.getPointerId(pointerIndex);

        // get masked (not specific to a pointer) action
        int maskedAction = event.getActionMasked();
        float x = event.getX();
        float y = event.getY();

        switch (maskedAction) {

            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN: {
                // TODO use data
                beginDraw(x, y);
                break;
            }
            case MotionEvent.ACTION_MOVE: { // a pointer was moved
                // TODO use data
                if (bDraw)
                    processDraw(x, y);
                break;
            }
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP: {
                if (bDraw)
                    endDraw(x, y);
                break;
            }
            case MotionEvent.ACTION_CANCEL: {
                // TODO use data
                break;
            }
        }

        return true;
    }

    private void endDraw(float x, float y) {
        bDraw = false;
        processDraw(x, y);
    }

    private void processDraw(float x, float y) {
        shape obj = shapes.get(shapes.size() - 1);
        obj.P2 = new Point((int)x, (int)y);
        invalidate();
    }

    private void beginDraw(float x, float y) {
        bDraw = true;
        shape obj = ShapeFactory.createShape(MyGlobal.ShapeSelection);
        obj.P1 = new Point((int)x, (int)y);
        obj.P2 = obj.P1;
        obj.penColor = MyGlobal.ColorSelection;
        obj.brushColor = MyGlobal.ColorSelection;
        shapes.add(obj);
        invalidate();

    }
}
