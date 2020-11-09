package com.offer;

public class Main {
    public static void main(String[] args) {
        int[] num = new int[]{10, 7, 3, 8, 9, 1, 2};
        int x = 0, y = 0;
        for (int i = 1; i < num.length; i++) {
            if(num[i] > num[x]) x = i;
            else if(num[i] < num[y]) y = i;
        }
        System.out.println(num[x] - num[y]);
    }

}
