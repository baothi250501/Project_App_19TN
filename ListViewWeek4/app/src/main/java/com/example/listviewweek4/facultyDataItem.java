package com.example.listviewweek4;

import java.io.Serializable;

public class facultyDataItem implements Serializable {
    public String Name;
    public String URL;
    public String Tel;

    public facultyDataItem(String name, String url, String tel){
        Name = name;
        URL = url;
        Tel = tel;
    }
}
