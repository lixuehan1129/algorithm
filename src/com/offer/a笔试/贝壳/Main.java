package com.offer.a笔试.贝壳;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int max = Math.max(x, y);
            max = Math.max(max, z);
            if(x == z && x == max){
                System.out.println("YES");
                System.out.println(1 + " " + y + " " + z);
            }else if(x == y && x == max){
                System.out.println("YES");
                System.out.println(1 + " " + z + " " + x);
            }else if(y == z && y == max){
                System.out.println("YES");
                System.out.println(1 + " " + x + " " + z);
            }else{
                System.out.println("NO");
            }

        }
        sc.close();
    }
}
