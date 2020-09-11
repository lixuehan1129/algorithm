package com.company.input;

import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(n + "-" + m);
        }
    }
}
