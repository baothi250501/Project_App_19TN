package com.example.smartedittext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements UsernameEditText.onLostFocus, UsernameEditText.onKeyUpListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEditText usernameEditText = (UsernameEditText) findViewById(R.id.editTextUserName);
        usernameEditText.setOnLostFocusListener(this);
        usernameEditText.setKeyUpListener(this);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if (newConfig.orientation ==Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
        }
        else if (newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main);// layout khác
        }
        super.onConfigurationChanged(newConfig);
    }



    @Override
    public void process(EditText editText) {
        String s = editText.getText().toString();
        Button btn = (Button) findViewById(R.id.buttonLogin);
        if (s.length() == 0)
            btn.setText("Cannot press");
        else
            btn.setText("Can press");
        //btn.setClickable(!s.isEmpty());
    }

    @Override
    public void process(int keyCode) {
        EditText editText = findViewById(R.id.myEditText1);
        editText.setText(String.valueOf(keyCode));
    }
}