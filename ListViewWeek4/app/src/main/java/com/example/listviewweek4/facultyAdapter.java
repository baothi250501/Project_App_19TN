package com.example.listviewweek4;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class facultyAdapter extends ArrayAdapter<facultyDataItem> {
    public facultyAdapter(Context context, ArrayList<facultyDataItem> facultyDataItems) {
        super(context, 0, facultyDataItems);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = createRow(position, parent);

        }
        return convertView;
    }

    private View createRow(int position, ViewGroup parent) {
        facultyDataItem dataItem = this.getItem(position);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.faculty_item_layout, null);
        //view = dataItem.createItemView()
        bindString2TextView(dataItem.Name, view, R.id.textViewFacultyName);
        bindString2TextView(dataItem.Tel, view, R.id.textViewTel);
        bindURL2TextView(dataItem.URL, view, R.id.buttonURL);

        return view;
    }

    private void bindURL2TextView(String url, View row, int idButton) {
        Button button = (Button) row.findViewById(idButton);
        button.setText(url);
        button.setTag(url);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse((String) view.getTag());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getContext().startActivity(intent);
            }
        });
    }

    private void bindString2TextView(String text, View row, int idTextView) {
        TextView textView = (TextView) row.findViewById(idTextView);
    }
}
