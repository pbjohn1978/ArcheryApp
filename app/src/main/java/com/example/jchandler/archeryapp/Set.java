package com.example.jchandler.archeryapp;

public class Set {
    private int[] arrows = new int[10];
    private int setNumber;

    public int[] Set(){
        for(int i = 0; i < arrows.length; i++){
            arrows[i] = 1;
        }
        return arrows;
    }

    public void SetSetID(int id){this.setNumber = id;}

    public int GetSetID(){return setNumber;}

    public int[] GetSetArrows(){return arrows;}

    public int getArrow1() { return arrows[0];}
    public int getArrow2() { return arrows[1];}
    public int getArrow3() { return arrows[2];}
    public int getArrow4() { return arrows[3];}
    public int getArrow5() { return arrows[4];}
    public int getArrow6() { return arrows[5];}
    public int getArrow7() { return arrows[6];}
    public int getArrow8() { return arrows[7];}
    public int getArrow9() { return arrows[8];}
    public int getArrow10() { return arrows[9];}

    public int[] setTheArrows(int a0, int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9){
        arrows[0] = a0;
        arrows[1] = a1;
        arrows[2] = a2;
        arrows[3] = a3;
        arrows[4] = a4;
        arrows[5] = a5;
        arrows[6] = a6;
        arrows[7] = a7;
        arrows[8] = a8;
        arrows[9] = a9;
        return arrows;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for ( int a: arrows ){
            sb.append(a + " ");
        }
        return String.valueOf(sb);
    }
}
