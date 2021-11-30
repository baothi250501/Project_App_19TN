package com.example.patternsdemoweek10;

import java.util.HashMap;

public class MyFlexibleObject {
    public HashMap<String, Object> attributes = new HashMap<>();
    private boolean bAutoAddNew;

    public MyFlexibleObject(){

    }

    public MyFlexibleObject(String strTypeName) {
        if (strTypeName == "PhanSo"){
            this.setAttributeValue("Tu so", 0);
            this.setAttributeValue("Mau so", 1);
            bAutoAddNew = false;
        }
    }

    public Object getAttributeValue(String strAttributeName){
        if (attributes.containsKey(strAttributeName))
            return attributes.get(strAttributeName);
        return null;
    }

    public boolean setAttributeValue(String strAttributeName, Object newValue){
        if (attributes.containsKey(strAttributeName)){ //update
            attributes.remove(strAttributeName);
            attributes.put(strAttributeName, newValue);
            return true;
        }
        else{
            if (bAutoAddNew){
                attributes.put(strAttributeName, newValue);
                return true;
            }
        }
        return false;
    }
}
