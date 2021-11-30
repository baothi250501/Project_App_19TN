package com.example.patternsdemoweek10;

public class RecruitByMaximumPrice extends RecruitRequirements {

    private final int maxPrice;

    public RecruitByMaximumPrice(int maxPrice){
        this.maxPrice = maxPrice;
    }

    @Override
    public boolean isOK(Unit unit) {
        return this.maxPrice >= unit.getPrice();
    }
}
