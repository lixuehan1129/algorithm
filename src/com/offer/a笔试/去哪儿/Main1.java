package com.offer.a笔试.去哪儿;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        String[] strings1 = new String[m];
        for (int i = 0; i < m; i++) {
            strings1[i] = sc.next();
            map.put(strings1[i], i);
        }
        String[] strings2 = new String[m];
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            strings2[i] = sc.next();
            nums[i] = map.get(strings2[i]);
        }
        sc.close();

        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);


    }
}
