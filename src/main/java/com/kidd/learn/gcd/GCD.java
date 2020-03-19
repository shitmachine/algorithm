package com.kidd.learn.gcd;

/**
 * 欧几里得算法（辗转相除法）
 */
public class GCD {

    public static void main(String[] args) {
        System.out.println(gcd(100, 30));
    }

    private static int gcd(int p, int q){
        if (q == 0){
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }
}
