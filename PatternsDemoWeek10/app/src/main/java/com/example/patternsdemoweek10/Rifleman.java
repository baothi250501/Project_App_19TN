package com.example.patternsdemoweek10;

public class Rifleman extends Unit{
    public Rifleman(){

    }
    public Rifleman(Rifleman refObj) {
        super();
    }

    @Override
    public Unit cloneUnit() {
        return new Rifleman(this);
    }
}
