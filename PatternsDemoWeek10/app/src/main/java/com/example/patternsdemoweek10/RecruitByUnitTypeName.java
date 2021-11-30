package com.example.patternsdemoweek10;

public class RecruitByUnitTypeName extends  RecruitRequirements {

    private final String strUnitTypeName;

    public RecruitByUnitTypeName(String strUnitTypeName){
        this.strUnitTypeName = strUnitTypeName;
    }

    @Override
    public boolean isOK(Unit unit) {
        return this.strUnitTypeName == unit.getTypeName();
    }
}
