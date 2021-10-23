package com.backjoon.fibonacci;

public class Test {
    long sum(int[] a) {
        long ans = 0;
        
        for(int b : a) ans += b;
        
        return ans;
    }
}
