package com.kidd.learn.other;

public class TestLogicItems {

    public static void main(String[] args) {
        System.out.println(checkAndOr());
        System.out.println(checkReverse());
    }


    public static boolean checkAndOr(){
        return true || false && false ;
    }

    public static boolean checkReverse(){
        return !true && true || false;
    }

}
