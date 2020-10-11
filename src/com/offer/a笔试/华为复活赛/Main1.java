package com.offer.a笔试.华为复活赛;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {
    private static boolean[] check;
    private static boolean[][] marked;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        Graph G = new Graph(n + 1);

        //
        marked = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            check = new boolean[n + 1];
            dfs(G, v);
            if(!check[w]){
                G.addEdge(v, w);
                count++;
            }

        }
        System.out.println(count);
        sc.close();

        /*
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        Graph G = new Graph(n + 1);
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            nums[i][0] = v;
            nums[i][1] = w;
            G.addEdge(v, w);
        }
        sc.close();

        marked = new boolean[n + 1][n + 1];
        check = new boolean[n + 1];
        for(int i = 0; i < m; i++){
            int v = nums[i][0];
            int w = nums[i][1];
            Queue<Integer> queue = G.adj(v);

        }
        System.out.println(count);

         */

    }

    public static void dfs(Graph G, int v){
        check[v] = true;
        for (Integer w : G.adj(v)) {
            if(!check[w]){
                dfs(G, w);
            }
        }
    }
}

class Graph{
    private final Queue<Integer>[] adj;
    public Graph(int v){
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    public void addEdge(int v, int w){
        adj[v].offer(w);
    }
    public Queue<Integer> adj(int v){
        return adj[v];
    }
}
