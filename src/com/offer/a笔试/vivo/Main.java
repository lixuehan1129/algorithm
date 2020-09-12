package com.offer.a笔试.vivo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        char[][] ch = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] chars = s.toCharArray();
            for (int j = 0; j < n; j++) {
                ch[i][j] = chars[j];
            }
        }


        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        queue.offer(new int[] {x1, y1});

        while (!queue.isEmpty()){
            count++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                if(x == x2 && y == y2){
                    System.out.println(count);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int lx = x + dx[i];
                    int ly = y + dy[i];
                    if(lx < 0 || lx >= n || ly < 0 || ly >= n) continue;
                    if(ch[lx][ly] == '#' || ch[lx][ly] == '@') continue;
                    queue.offer(new int[] {lx, ly});
                }
            }

        }
    }
}
