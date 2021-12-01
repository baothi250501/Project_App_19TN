package com.example.gameweek2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

@SuppressLint("AppCompatCustomView")
public class SmartEditText extends EditText {

    interface MyOperation
    {
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


    private  MyOperation multiplication = new MyOperation() {
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

    private Map<String, MyOperation> myOperationMap = null;


    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused) // bắt đầu nhập liệu, nhập tiếp
        {
            this.setText("");
        }
        else // nhập xong
        {
            String s = this.getText().toString();
            if (myOperationMap==null) {
                myOperationMap = new HashMap<>();
                myOperationMap.put("+", addition);
                myOperationMap.put("-", subtraction);
                myOperationMap.put("*", multiplication);
                myOperationMap.put("x", multiplication);
                myOperationMap.put(".", multiplication);
            }
            if (s.length()>0) {
                String[] tokens = s.split(" "); // 123 + 456
                int a = Integer.parseInt(tokens[0]);
                int b = Integer.parseInt(tokens[2]);
                //        int c = a + b;
                int c = myOperationMap.get(tokens[1]).process(a, b);
                this.setText(String.valueOf(c));
            }
        }
    }
}
