package com.example.productlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class productDataItem  {
    public productDataItem(){

    }

    public abstract View createItemView(LayoutInflater context, productDataItem dataItem);

    public void bindString2TextView(String text, View row, int idTextView) {
        TextView textView = (TextView) row.findViewById(idTextView);
        textView.setText(textView.getText() + text);
    }

    public void bindImageRcrId2ImageView(int imageResourceId,View row, int idImageView) {
        ImageView imageView = (ImageView) row.findViewById(idImageView);
        imageView.setImageResource(imageResourceId);
    }

}
