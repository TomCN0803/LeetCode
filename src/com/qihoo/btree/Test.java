package com.qihoo.btree;

public class Test {
    public static void main(String[] args) {
        int n = 5;
        int x = 0;
        for (int i = 2; i <= n; ++i) {
            for (int j = 2; j <= i - 1; ++j) {
                ++x;
                System.out.println(x);
            }
        }
    }
}
