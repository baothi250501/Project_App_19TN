package com.example.patternsdemoweek10;

public class Pikeman extends Unit{
    public Pikeman(){

    }
    public Pikeman(Pikeman refObj) {
        super();
    }

    @Override
    public Unit cloneUnit() {
        return new Pikeman(this);
    }
}
