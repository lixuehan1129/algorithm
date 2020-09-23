package com.offer.a笔试.去哪儿;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
        long num1 = 1, num2 = 1;
        int size = m - n;
        while (m > size)
            num1 = num1 * (m--);
        while (n > 0){
            num2 = num2 * (n--);
        }
        System.out.println(num1 / num2);

    }
}
