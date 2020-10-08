package com.offer.a笔试.便利蜂;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] ch = new String[n][2];
        for (int i = 0; i < n; i++){
            String str = sc.next();
            ch[i][0] = str.substring(0, 1);
            ch[i][1] = str.substring(3, 4);
        }
    }

}
