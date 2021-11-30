package com.example.patternsdemoweek10;

import java.util.ArrayList;
import java.util.List;

public class MyButton {
    protected ArrayList<MyButton.OnClickListener> followers = new ArrayList<MyButton.OnClickListener>();

    public interface OnClickListener{
        boolean action(MyButton sender);
    }

    public void addOnClickListener(OnClickListener listener){
        followers.add(listener);
    }

    public void clickMe(){
        for (MyButton.OnClickListener listener:followers){
            listener.action(this);
        }
    }


}
