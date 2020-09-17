package com.offer.a笔试.伴鱼;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(movingCount(127, 127, 177));

    }

    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int count = 0;
    public static int movingCount (int m, int n, int k) {
        // write code here
        if(m <= 0 || n <= 0 || k < 0) return 0;
        boolean[][] isCheck = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                isCheck[x][y] = true;
                count++;
                for (int j = 0; j < 2; j++) {
                    int lx = x + dx[j];
                    int ly = y + dy[j];
                    if (lx < 0 || ly < 0 || lx >= m || ly >= n || isCheck[lx][ly] || check(lx, ly) > k) continue;
                    queue.offer(new int[]{lx, ly});
                }
            }
        }

        //dfs(0, 0, m, n, k, isCheck);
        return count;
    }

    public static void dfs(int x, int y, int m, int n, int k, boolean[][] isCheck){
        if(isCheck[x][y] || check(x, y) > k){
            isCheck[x][y] = true;
            return;
        }
        isCheck[x][y] = true;
        count++;
        System.out.println(x + "-" + y + "-" + count);
        for(int i = 0; i < 4; i++){
            int lx = x + dx[i];
            int ly = y + dy[i];
            if(lx < 0 || ly < 0 || lx >= m || ly >= n) continue;
            dfs(lx, ly, m, n, k, isCheck);
        }
    }

    public static int check(int x, int y){
        int sum = 0;
        while(x > 0){
            sum += x % 10;
            x /= 10;
        }
        while(y > 0){
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }
}
