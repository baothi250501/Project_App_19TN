package com.example.week1app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}