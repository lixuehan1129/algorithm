package com.offer.a笔试.JD;

import java.util.Scanner;

public class Main1 {

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char[][] ch = new char[n][m];
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.next();
                for (int j = 0; j < m; j++) {
                    ch[i][j] = s.charAt(j);
                    if(ch[i][j] == 'S'){
                        x = i;
                        y = j;
                    }
                }
            }
            boolean[][] isCheck = new boolean[n][m];
            check = false;
            dfs(x, y, n, m, ch, isCheck);
            if (check) System.out.println("YES");
            else System.out.println("No");
        }
    }

    public static void dfs(int x, int y, int n, int m, char[][] ch, boolean[][] isCheck){
        if(isCheck[x][y]) return;
        isCheck[x][y] = true;
        if(ch[x][y] == 'E') {
            check = true;
        }
        for (int i = 0; i < 4; i++) {
            int lx = x + dx[i], ly = y + dy[i];
            if(lx < 0 || lx >= n || ly < 0 || ly >= m || ch[lx][ly] == '#') continue;
            dfs(lx, ly, n, m, ch, isCheck);
        }
    }
}
