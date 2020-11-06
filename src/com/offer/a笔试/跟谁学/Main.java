package com.offer.a笔试.跟谁学;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int colT = 0, rowT = 0, colB = n - 1, rowB = n - 1;
        while(colT <= colB && rowT <= rowB){
            rotateEdge(nums, colT++, rowT++, colB--, rowB--);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateEdge(int[][] nums, int colT, int rowT, int colB, int rowB){
        int l = colB - colT;
        for (int i = 0; i < l; i++) {
            int tmp = nums[colT][rowT + i];
            nums[colT][rowT + i] = nums[colB][rowB - i];
            nums[colB][rowB - i] = tmp;

            tmp = nums[colT + i][rowB];
            nums[colT + i][rowB] = nums[colB - i][rowT];
            nums[colB - i][rowT] = tmp;

        }
    }
}
