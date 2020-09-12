package com.offer.a笔试.奇安信;


public class Main1 {
    public static void main(String[] args) {
        int su = maxCandies(new int[] {3,5,7,2,8,8,15,3}, new int[] {1,0,1,0,1,0,1,0}, 3);
        System.out.println(su);
    }

    public static int maxCandies (int[] candies, int[] coin, int n) {
        // write code here
        int len = candies.length;
        int oldSum = 0;
        for (int i = 0; i < len; i++) {
            if(coin[i] == 0) oldSum += candies[i];
        }
        return oldSum;
    }
}
