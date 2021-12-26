package com.example.smartedittext;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

public class SmartEditText extends androidx.appcompat.widget.AppCompatEditText {

    interface MyOperation{
        int process(int a, int b);
    }

    private MyOperation addition = new MyOperation() {
        @Override
        public int process(int a, int b) {
            return a+b;
        }
    };

    private MyOperation subtraction = new MyOperation() {
        @Override
        public int process(int a, int b) {
            return a-b;
        }
    };

    private MyOperation multiplication = new MyOperation() {
        @Override
        public int process(int a, int b) {
            return a*b;
        }
    };

    public SmartEditText(Context context) {
        super(context);
    }

    public SmartEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Map<String, MyOperation> myOperationMap;

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused){ //Bat dau nhap lieu, nhap tiep
            this.setText("");
        } else { //Nhap xong
            String s = this.getText().toString();
            if (myOperationMap==null) {
                myOperationMap = new HashMap<>();
                myOperationMap.put("+", addition);
                myOperationMap.put("-", subtraction);
                myOperationMap.put("*", multiplication);
                myOperationMap.put("x", multiplication);
                myOperationMap.put(".", multiplication);
            }
            if(s.length()>0){
                String[] tokens = s.split(" ");
                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[2]);
                // int c = a + b;
                int c = myOperationMap.get(tokens[1]).process(a, b);
                this.setText(String.valueOf(c));
            }
        }
    }
}
