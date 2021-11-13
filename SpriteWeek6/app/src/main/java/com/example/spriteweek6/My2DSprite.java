package com.example.spriteweek6;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class My2DSprite {
    public int nBMPs;
    public int iBMP;
    public Bitmap[] BMPs;
    public int left;
    public int top;
    public int width;
    public int height;
    public boolean State = false;

    public My2DSprite(Bitmap[] bmps, int left, int top, int width, int height){
        BMPs = bmps;
        nBMPs = bmps.length;
        iBMP = 0;
        this.left = left;
        this.top = top;
        if (width == 0 && height==0)
        {
            width = bmps[0].getWidth();
            height = bmps[0].getHeight();
        }
        this.width = width;
        this.height = height;
    }

    public void update(){
        iBMP = (iBMP+1) % nBMPs;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(BMPs[iBMP], left, top, null);
    }

    public boolean isSelected (float x, float y){
        return (x >= left && x < left+width && y >= top && y < top+height);
    }
}

