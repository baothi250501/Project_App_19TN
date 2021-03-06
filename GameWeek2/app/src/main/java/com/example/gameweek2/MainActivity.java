package com.example.gameweek2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNewGame(View view) {
        Intent intent = new Intent(this, ConfigActivity.class);
        intent.putExtra("helloString", "Hello World");
        intent.putExtra("defaultRowCount", 5);
        intent.putExtra("defaultColumnCount", 5);
        startActivity(intent); // Khong quan tam ket qua tra ve
        //startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1234)
        {
            if (resultCode==RESULT_OK)
            {
                int nRows = data.getIntExtra("nRows", 5);
                int nColumns = data.getIntExtra("nColumns", 5);
                genGameData(nRows, nColumns);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void genGameData(int nRows, int nColumns) {
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridMain);
        gridLayout.setColumnCount(nColumns);
        gridLayout.setRowCount(nRows);
        int nButtons = nColumns * nRows;
        Button btn;
        for (int i=0; i<nButtons; i++)
        {
            btn = createCellInGame(60000+i);
            gridLayout.addView(btn);
        }
    }

    private Button createCellInGame(int id) {
        Button button = new Button(this);
        button.setId(id);
        button.setText("*");
        return button;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        if (newConfig.orientation ==Configuration.ORIENTATION_PORTRAIT)
        {
            setContentView(R.layout.activity_main);
        }
        else if (newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE)
        {
            setContentView(R.layout.activity_main);// layout kh??c
        }
        super.onConfigurationChanged(newConfig);
    }
}