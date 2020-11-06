package com.offer.a笔试.贝壳;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums = new int[n];
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            //Set<Integer> set = new HashSet<>();
            int has = 0;
            for (int j = 0; j < n; j++) {
                if(nums[j] > m || nums[j] == 0) continue;
                if(set.contains(nums[j])){
                    System.out.println("yes");
                    has = 1;
                    break;
                }else{
                    if(m % nums[j] == 0){
                        set.add(m / nums[j]);
                    }
                }
            }
            if(has == 0) System.out.println("no");

        }
    }
}
