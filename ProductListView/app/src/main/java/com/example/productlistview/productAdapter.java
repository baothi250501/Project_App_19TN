package com.example.productlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class productAdapter extends ArrayAdapter<productDataItem> {

    public productAdapter(Context context, ArrayList<productDataItem> productDataItems) {
        super(context, 0, productDataItems);
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
        productDataItem dataItem = this.getItem(position);
        View view = null;
        if (dataItem instanceof handbookDataItem || dataItem instanceof penCaseDataItem) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            view = dataItem.createItemView(layoutInflater, dataItem);
        }
        return view;
    }



}
