package com.offer.a笔试.贝壳;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] check = new boolean[2004];
        for (int i = 3; i < 2004; i += 2) {
            if(!check[i]){
                for (int j = 3; i * j < 2004; j += 2) {
                    check[i * j] = true;
                }
            }
        }
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int sum = x + y;
            int nSum = sum;
            if(sum % 2 == 0) nSum++;
            else nSum += 2;
            while (check[nSum]){
                nSum += 2;
            }
            System.out.println(nSum - sum);

        }
    }
}
