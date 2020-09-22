package com.offer.a笔试.度小满;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();

            if(str == null || str.length() < 3){
                System.out.println("N0");
                continue;
            }

            int len = str.length();
            if(len % 3 != 0){
                System.out.println("N0");
                continue;
            }
            int count = 0;
            for (int j = 3; j < len - 3; j = j + 3) {
                count = 0;
                if(str.charAt(j) == str.charAt(j + 3)) count++;
                if(str.charAt(j + 1) == str.charAt(j + 4)) count++;
                if(str.charAt(j + 2) == str.charAt(j + 5)) count ++;
            }
            if(count < 2){
                System.out.println("No");
            }else{
                System.out.println("Yes");
            }
        }
    }
}
