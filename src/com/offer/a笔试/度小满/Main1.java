package com.offer.a笔试.度小满;

import java.util.Scanner;

public class Main1 {
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int l = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = 0, y = 0;
        char[][] chars = new char[n][m];
        for (int j = 0; j < n; j++) {
            String str = sc.next();
            for (int k = 0; k < m; k++) {
                chars[j][k] = str.charAt(k);
                if(chars[j][k] == '@'){
                    x = j;
                    y = k;
                }
            }
        }

        //
        boolean[][] isCheck = new boolean[n][m];
        min = Integer.MAX_VALUE;
        dfs(x, y, chars, isCheck, 0);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    public static void dfs(int x, int y, char[][] chars, boolean[][] isCheck, int count){
        if(isCheck[x][y]) return;
        isCheck[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int lx = x + dx[i], ly = y + dy[i];
            if(lx < 0 || lx >= chars.length || ly < 0 || ly >= chars[0].length){
                min = Math.min(count, min);
                continue;
            }
            if(chars[lx][ly] == '#') continue;
            if(chars[lx][ly] == '.') dfs(lx, ly, chars, isCheck, count);
            if(chars[lx][ly] == '*') dfs(lx, ly, chars, isCheck, count + 1);
        }
    }
}

