package com.offer.dp;

/**
 * 背包问题
 * weight 重量   value 价值    W 容量
 * https://www.kancloud.cn/kancloud/pack/70126
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] weight = {1, 4, 3};
        int[] value = {15, 30, 20};
        int W = 5;
        System.out.println(maxValueOn(weight, value, W));
    }
    public static int maxValue(int[] weight, int[] value, int W){
        int n = weight.length;
        if(n == 0) return 0;
        // dp[i][w] 表示前 i 件物品放入容量为 w 的背包中可获得的最大价值
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                //存放i号物品（前提放得下）
                if (j < weight[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[n][W];
    }
    public static int maxValueOn(int[] weight, int[] value, int W){
        int n = weight.length;
        if(n == 0) return 0;
        int[] dp = new int[W + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = W; j >= weight[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i - 1]] + value[i - 1]);
            }
        }
        return dp[W];
    }
}
