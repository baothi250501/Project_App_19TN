package com.example.gameweek2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;

@SuppressLint("AppCompatCustomView")
public class UsernameEditText extends EditText {
    public UsernameEditText(Context context) {
        super(context);
    }

    public UsernameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    interface onLostFocus
    {
        void process(EditText editText);
    }

    private onLostFocus onLostFocusListener = null;

    public void setOnLostFocusListener(onLostFocus listener)
    {
        onLostFocusListener = listener;
    }


    interface  onKeyUpListener
    {
        void process (int keyCode);
    }

    private onKeyUpListener keyUpListener = null;
    public void setKeyUpListener(onKeyUpListener listener)
    {
        keyUpListener = listener;
    }
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        boolean b =  super.onKeyUp(keyCode, event);
        if (keyUpListener!=null)
            keyUpListener.process(keyCode);
        return b;
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused==false)
        {
            if (onLostFocusListener!=null)
                onLostFocusListener.process(this);
        }
    }
}
