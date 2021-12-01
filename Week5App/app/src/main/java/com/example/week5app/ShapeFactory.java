package com.example.week5app;

public class ShapeFactory {
    public static shape createShape(String strShapeType) {
        if (strShapeType=="Rectangle")
            return new myRectangle();
        else if (strShapeType=="Line")
            return new myLine();
        return new myLine();
    }

}
