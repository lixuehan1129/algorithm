package com.offer.a笔试.华为复活赛;


import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < m * n; i++){
            queue.offer(sc.nextInt());
        }

        sc.close();
        //
        int[][] result = new int[m][n];
        int depth = (Math.min(m, n) + 1) / 2;
        for (int i = 0; i < depth; i++) {
            int rightB = n - i - 1, bottomB = m - i - 1;
            int l = i, r = i;
            if(i == rightB){
                for(int a = i; a <= bottomB; a++) result[l][a] = queue.poll();
                break;
            }
            if(i == bottomB){
                for (int a = i; a <= rightB; a++) result[a][r] = queue.poll();
                break;
            }
            while (r < rightB) result[l][r++] = queue.poll();
            while (l < bottomB) result[l++][r] = queue.poll();
            while (r > i) result[l][r--] = queue.poll();
            while (l > i) result[l--][r] = queue.poll();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
