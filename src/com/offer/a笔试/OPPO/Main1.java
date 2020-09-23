package com.offer.a笔试.OPPO;

import java.util.Scanner;

/**
 * java String中indexof方法可以找到第一个匹配字符串的位置
 */
public class Main1 {
    public static void main(String[] args) {
        //输入两个字符串 A B
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();
        sc.close();
        //返回出现的第一个位置(从0开始)
        System.out.println(A.indexOf(B));
    }
}
