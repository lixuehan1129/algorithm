package com.offer.a笔试.网易;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String stopWord = sc.nextLine();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        Set<String> set = new HashSet<>();
        String[] stopWords = stopWord.split(" ");
        set.addAll(Arrays.asList(stopWords));

        String[] str1s = str1.split(" ");
        String[] str2s = str2.split(" ");


        List<String> newStr1 = new ArrayList<>();
        List<String> newStr2 = new ArrayList<>();

        for (String s : str1s) {
            if(set.contains(s)) continue;
            newStr1.add(s);
        }
        for (String s : str2s) {
            if(set.contains(s)) continue;
            newStr2.add(s);
        }

        int n = newStr1.size();
        int m = newStr2.size();
        System.out.println(newStr1.toString());
        System.out.println(newStr2.toString());

        if(n * m == 0) System.out.println(n + m);

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int left_down = dp[i - 1][j - 1];
                if(!newStr1.get(i - 1).equals(newStr2.get(j - 1))) left_down += 1;
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }

        System.out.println(dp[n][m]);

    }
}
