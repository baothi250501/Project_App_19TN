package com.example.myprofile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    Bundle newBundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);
        if (savedInstanceState != null)
            onRestoreInstanceState(newBundle);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        onRestoreInstanceState(newBundle);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.activity_main);
        }
        else if (newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.activity_main); //different layout
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("editText",String.valueOf(mEditText.getText()));
        newBundle.putString("editText",String.valueOf(mEditText.getText()));
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState (Bundle mySavedState) {

        super.onRestoreInstanceState(mySavedState);
        if (mySavedState != null) {
            String editText = mySavedState.getString("editText");
            mEditText = findViewById(R.id.editText);
            mEditText.setText(editText);
        }

    }

}