package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText res;
    int check, value1, value2;
    private View.OnClickListener helper = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            //Button 2
            if (btn.getId()==65000+2){
                res.setText("");
            }
            //Button ./.
            if (btn.getId()== 65000+7){
                if (res.getText().length() != 0 && res.getText().equals("-") == false){
                    value1 = Integer.parseInt(res.getText()+"");
                    check = 4;
                    res.setText(null);
                }
            }
            //Button 7
            if (btn.getId()== 65000+8){
                res.setText(res.getText() + "7");
                Log.i("MainActivity","7");
            }
            //Button 8
            if (btn.getId()== 65000+9){
                res.setText(res.getText() + "8");
                Log.i("MainActivity","8");
            }
            //Button 9
            if (btn.getId()== 65000+10){
                res.setText(res.getText() + "9");
                Log.i("MainActivity","9");
            }
            //Button *
            if (btn.getId()== 65000+11){
                if (res.getText().length() != 0 && res.getText().equals("-") == false){
                    value1 = Integer.parseInt(res.getText()+"");
                    check = 3;
                    res.setText("");
                    Log.i("MainActivity","*");
                }
            }
            //Button 4
            if (btn.getId()== 65000+12){
                res.setText(res.getText() + "4");
                Log.i("MainActivity","4");
            }
            //Button 5
            if (btn.getId()== 65000+13){
                res.setText(res.getText() + "5");
                Log.i("MainActivity","8");
            }
            //Button 6
            if (btn.getId()== 65000+14){
                res.setText(res.getText() + "6");
                Log.i("MainActivity","8");
            }
            //Button -
            if (btn.getId()== 65000+15){
                if (res.getText().length() == 0){
                    res.setText("-");
                } else {
                    if (res.getText().equals("-") == false){
                        value1 = Integer.parseInt(res.getText()+"");
                        check = 2;
                        res.setText("");
                        Log.i("MainActivity","*");
                    }
                }
            }
            //Button 1
            if (btn.getId()== 65000+16){
                res.setText(res.getText() + "1");
                Log.i("MainActivity","1");
            }
            //Button 2
            if (btn.getId()== 65000+17){
                res.setText(res.getText() + "2");
                Log.i("MainActivity","2");
            }
            //Button 3
            if (btn.getId()== 65000+18){
                res.setText(res.getText() + "3");
                Log.i("MainActivity","3");
            }
            //Button +
            if (btn.getId()== 65000+19){
                if (res.getText().length() != 0 && res.getText().equals("-") == false){
                    value1 = Integer.parseInt(res.getText()+"");
                    check = 1;
                    res.setText("");
                    Log.i("MainActivity","+");
                }
            }
            //Button 0
            if (btn.getId()== 65000+21){
                res.setText(res.getText() + "0");
                Log.i("MainActivity","0");
            }
            //Button =
            if (btn.getId()== 65000+23){
                if (res == null)
                    res.setText("");
                else {
                    value2 = Integer.parseInt(res.getText()+"");
                    res.setText(null);
                    Log.i("MainActivity",Integer.toString(check));
                    switch(check){
                        case 1: {
                            res.setText(value1 + value2 + "");
                            check = 0;
                        }
                            break;
                        case 2: {
                            res.setText(value1 - value2 + "");
                            check = 0;
                        }
                            break;
                        case 3: {
                            res.setText(value1 * value2 + "");
                            check = 0;
                        }
                            break;
                        case 4: {
                            res.setText(value1 / value2 + "");
                            check = 0;
                        }
                            break;
                    }
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = (EditText) findViewById(R.id.editTextNumber);
        check = 0;
        add24ButtonForMePlease();
    }

    private void add24ButtonForMePlease() {
        LinearLayout[] rows = create6RowsPlease();
        add6RowsToMainLayout(rows);
        String[] labels = initAllLabelsPlease();
        Button btn;
        int rowIndex;
        for (int i = 0; i < 24; ++i){
            btn = createButtonPlease(labels[i], 65000+i);
            rowIndex = i/4;
            addButtonToRowPlease(btn, rows[rowIndex]);
        }
    }

    private String[] initAllLabelsPlease() {
        String[] labels = new String[] {
                "%", "CE", "C", "BkSp",
                "1/x", "x^2", "sqrt", "./.",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "+/-", "0", ".", "="
        };
        return labels;
    }

    private void add6RowsToMainLayout(LinearLayout[] rows) {
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearlayoutmain);
        for (int i = 0; i < rows.length; ++i){
            linearLayout.addView(rows[i]);
        }
    }

    private void addButtonToRowPlease(Button btn, LinearLayout row) {
        row.addView(btn);
    }

    private Button createButtonPlease(String label, int id) {
        Button button = new Button(this);
        button.setText(label);
        button.setId(id);

        button.setOnClickListener(helper);
        return button;
    }

    private LinearLayout[] create6RowsPlease() {
        LinearLayout[] rows = new LinearLayout[6];
        for (int i = 0; i < 6; ++i){
            rows[i] = createRow(65000+i);
        }
        return rows;
    }

    private LinearLayout createRow(int id) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setId(id);
        return linearLayout;
    }

    public void onNhanNutMC(View view){
        Button btn = (Button)view;
        if (btn.getId()==R.id.buttonMC)
            btn.setText("MC Clicked");
        else if (btn.getId()==R.id.buttonMR)
            btn.setText("MR Clicked");
    }
}