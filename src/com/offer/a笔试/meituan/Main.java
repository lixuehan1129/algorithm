package com.offer.a笔试.meituan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{5, 4, 5, 4, 5, 5, 5, 5};
        int len = nums.length;
        int i = 0, j = 0;
        int m = 2;//滑动窗口值
        int k = 5;
        int count = 0;
        while (j - i < m - 1 && j < len){
            if(nums[j] >= k)
            j++;
            if(nums[j] < k) i = j;
        }
        if(j - i == m) count++;
        while (j < len){
            if(nums[j] >= k){
                j++;
                i++;
                count++;
            }else{
                j++;
                i = j;
                while (j - i < m && j < len){
                    j++;
                    if(nums[j] < k) i = j;
                }
                if(j - i == m) count++;
            }
        }
        System.out.println(count);
    }


}


