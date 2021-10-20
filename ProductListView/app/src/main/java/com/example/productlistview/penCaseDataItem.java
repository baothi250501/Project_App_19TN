package com.example.productlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class penCaseDataItem extends productDataItem {
    private int mImageResourceId;
    private String mProductName;
    private String mColor;
    private String mStructure;
    private String mSize;

    public penCaseDataItem(String productName,String color, String structure, String size, int imageResourceId){
        mImageResourceId = imageResourceId;
        mProductName = productName;
        mColor = color;
        mStructure = structure;
        mSize = size;
    }

    @Override
    public View createItemView(LayoutInflater layoutInflater, productDataItem dataItem) {
        View view = layoutInflater.inflate(R.layout.pencase_item_layout, null);
        bindImageRcrId2ImageView(((penCaseDataItem) dataItem).mImageResourceId,view, R.id.productImage);
        bindString2TextView(((penCaseDataItem) dataItem).mProductName, view, R.id.productName);
        bindString2TextView(((penCaseDataItem) dataItem).mColor, view, R.id.color);
        bindString2TextView(((penCaseDataItem) dataItem).mStructure, view, R.id.structure);
        bindString2TextView(((penCaseDataItem) dataItem).mSize, view, R.id.size);
        return view;
    }
}
