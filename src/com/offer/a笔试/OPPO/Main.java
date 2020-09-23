package com.offer.a笔试.OPPO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输入 m行n列
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        sc.close();
        //dp分析法 dp[i][j] = max(dp[i-1][j], dp[i][j-1])+nums[i][j]
        //先初始化上边界和左边界
        int[][] dp = new int[m][n];
        dp[0][0] = nums[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + nums[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + nums[i][0];
        }
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + nums[i][j];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
