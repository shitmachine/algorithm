package com.kidd.learn.other;

/**
 * 普通表示的值
 */
public class BaseExpression {

    public static void main(String[] args) {

        System.out.println((0 + 15) / 2); // 7
        System.out.println(2.0e-6 * 100000000.1); // 200.0000002
        System.out.println(true && false || true && true); // true

        System.out.println((1 + 2.236) / 2); // 1.618
        System.out.println(1 + 2 + 3 + 4.0); // 10.0

        System.out.println(4.1 >= 4); // true
        System.out.println(1 + 2 + "3"); // 33

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char)('b' + 1));




    }

}
