package com.example.productlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class handbookDataItem extends productDataItem {
    private int mImageResourceId;
    private String mProductName;
    private String mColor;
    private String mType;
    private int mPageNumber;
    private String mPaperSize;

    public handbookDataItem(String productName,String color, String type, int pageNumber, String paperSize, int imageResourceId){
        mImageResourceId = imageResourceId;
        mProductName = productName;
        mColor = color;
        mType = type;
        mPageNumber = pageNumber;
        mPaperSize = paperSize;
    }


    @Override
    public View createItemView(LayoutInflater layoutInflater, productDataItem dataItem) {
        View view = layoutInflater.inflate(R.layout.handbook_item_layout, null);
        bindImageRcrId2ImageView(((handbookDataItem) dataItem).mImageResourceId,view, R.id.productImage);
        bindString2TextView(((handbookDataItem) dataItem).mProductName, view, R.id.productName);
        bindString2TextView(((handbookDataItem) dataItem).mColor, view, R.id.color);
        bindString2TextView(((handbookDataItem) dataItem).mType, view, R.id.type);
        bindString2TextView(Integer.toString(((handbookDataItem) dataItem).mPageNumber), view, R.id.pageNumber);
        bindString2TextView(((handbookDataItem) dataItem).mPaperSize, view, R.id.paperSize);
        return view;
    }
}
