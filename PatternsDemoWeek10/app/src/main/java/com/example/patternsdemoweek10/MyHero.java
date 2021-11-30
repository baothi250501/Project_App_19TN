package com.example.patternsdemoweek10;

public class MyHero {
    private MyHero(){

    }

    /*private static MyHero instance = new MyHero();
    public static MyHero getInstance(){
        return instance;
    }*/

    private static int nCount = 0;
    private static int nMax = 1;
    public static MyHero summonHero(){
        /*if (nCount < nMax){
            nCount++;
            return new MyHero();
        }*/
        if (canSummonHero()){
            nCount++;
            MyHero ret = new MyHero();
            postProcessingAction();
            return ret;
        }
        return null;
    }

    private static void postProcessingAction() {
        nCount++;
    }

    private static boolean canSummonHero() {
        return nCount < nMax;
    }
}
