package com.example.patternsdemoweek10;

import androidx.annotation.NonNull;

public class Swordman extends  Unit{

    public Swordman(){

    }
    public Swordman(Swordman refObj) {
        super();
    }

    @Override
    public Unit cloneUnit() {
        return new Swordman(this);
    }
}
