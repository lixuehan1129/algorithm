package com.offer.a笔试.meituan;

import java.util.Scanner;
public class JuZhen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        midC(nums, n, m);
    }
    public static void midC(int[][] nums, int length, int m){
        int mid = length / 2;
        int check = length % 2;
        boolean same = true;
        if(check == 1){
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }
        }else{
            for (int i = 0; i < mid; i++) {
                for (int j = 0; j < m; j++) {
                    if(nums[i][j] != nums[length - 1 - i][j]){
                        same = false;
                        break;
                    }
                }
            }
            if(!same){
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(nums[i][j] + " ");
                    }
                    System.out.println();
                }
            }else{
                midC(nums, mid, m);
            }
        }
    }
}
