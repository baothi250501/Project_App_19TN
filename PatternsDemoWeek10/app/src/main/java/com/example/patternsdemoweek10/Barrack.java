package com.example.patternsdemoweek10;

import java.util.HashMap;

public class Barrack {
    //version 1
    public Unit recruitUnit(String strUnitType){
        if (strUnitType=="Swordman"){
            return new Swordman();
        } else if (strUnitType=="Pikeman"){
            return new Pikeman();
        } else if (strUnitType=="Rifleman"){
            return new Rifleman();
        }
        return recruitDefaultUnit();
    }

    private HashMap<String, Unit> sampleUnits = new HashMap<>();

    public void populateSampleUnits(){
        //prototype
        sampleUnits.put("Amateur Swordman", new Swordman());
        sampleUnits.put("Amateur Pikeman", new Pikeman());
        sampleUnits.put("Amateur Rifleman", new Rifleman());
        sampleUnits.put("Veteran Swordman", new Swordman());
        sampleUnits.put("Veteran Pikeman", new Pikeman());
        sampleUnits.put("Veteran Rifleman", new Rifleman());
        //Update attribute cho phu hop voi amateur hay veteran
    }

    //version 2
    public Unit recruitUnit_v2(String strUnitType){
        Unit res = null;
        if (sampleUnits.containsKey(strUnitType)){
            res = sampleUnits.get(strUnitType).cloneUnit();
            return res;
        }
        return recruitDefaultUnit();
    }

    //version 3
    public Unit recruitUnit_v3(RecruitRequirements requirements){
        for (Unit unit: sampleUnits.values()){
            if (isOK(unit, requirements))
                return unit.cloneUnit();
            //if (unit.satisfyConditions(requirements))
            //if (requirements.isOK(unit))
        }
        return recruitDefaultUnit();
    }

    private boolean isOK(Unit unit, RecruitRequirements requirements) {
        return requirements.isOK(unit);
    }

    private Unit recruitDefaultUnit(){
        return new Swordman();
    }
}
