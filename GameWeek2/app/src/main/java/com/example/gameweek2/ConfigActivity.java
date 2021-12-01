package com.example.gameweek2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String strHelloString = intent.getStringExtra("helloString");
        int nDefaultRowCount = intent.getIntExtra("defaultRowCount", 2);
        int nDefaultColumnCount = intent.getIntExtra("defaultColumnCount", 2);
        setEditTextContentWithInteger(R.id.editRowCount, nDefaultRowCount);
        setEditTextContentWithInteger(R.id.editColumnCount, nDefaultColumnCount);
        setContentView(R.layout.activity_config);
    }

    private void setEditTextContentWithInteger(int idEditText, int v) {
        EditText editText = (EditText)findViewById(idEditText);
        editText.setText(String.valueOf(v));
    }

    public void onOK(View view) {
        int nRows = getIntegerFromEditText(R.id.editRowCount);
        int nCols = getIntegerFromEditText(R.id.editColumnCount);
        Intent intent = new Intent();
        intent.putExtra("nRows", nRows);
        intent.putExtra("nColumns", nCols);
        setResult(RESULT_OK, intent);
        finish();
    }

    private int getIntegerFromEditText(int idEditText) {
        EditText editText = (EditText)findViewById(idEditText);
        String s = editText.getText().toString();
        return Integer.parseInt(s);
    }

    public void onCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
