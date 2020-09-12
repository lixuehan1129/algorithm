package com.offer.dp;

public class Piece {
    public static void main(String[] args) {

    }
    public static int solution(int nLevel, int kChess){
        if(nLevel < 1 || kChess < 1) return 0;
        if(kChess == 2) return nLevel;
        int[][] dp = new int[nLevel + 1][kChess + 1];
        for (int i = 0; i != dp.length ; i++) {
            dp[i][1] = i;
        }
        for (int i = 0; i != dp.length; i++) {
            for (int j = 2; j != dp[0].length; j++) {
                int min = Integer.MIN_VALUE;
                for (int k = 1; k != i + 1 ; k++) {
                    min = Math.min(min, Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[nLevel][kChess];
    }

    public static int Solution(int nLevel, int kChess){
        if(nLevel < 1 || kChess < 1) return 0;
        if(kChess == 2) return nLevel;
        int bsTimes = log2N(nLevel) + 1;
        if(kChess >= bsTimes) return bsTimes;
        int[] dp = new int[kChess];
        int res = 0;
        while (true){
            res++;
            int pre = 0;
            for (int i = 0; i < dp.length; i++) {
                int tmp = dp[i];
                dp[i] = dp[i] + pre + 1;
                pre = tmp;
                if(dp[i] >= nLevel){
                    return res;
                }
            }
        }
    }

    public static int log2N(int n){
        int res = -1;
        while (n != 0){
            res++;
            n >>>= 1;
        }
        return res;
    }
}
