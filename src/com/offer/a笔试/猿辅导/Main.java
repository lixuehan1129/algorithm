package com.offer.a笔试.猿辅导;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String str = sc.nextLine();
            str = str.trim();
            Stack<Integer> stack = new Stack<>();
            if(str.charAt(0) != '('){
                System.out.println("invalid");
                continue;
            }
            //stack.push(str.charAt(0));

            for(int j = str.length() - 1; j >= 0; --j){
                char item = str.charAt(j);
                if(item == ' ') continue;
                if(item == ')' || item == '('){
                    continue;
                }
//                if(item == '(' && stack.peek() == ')'){
//                    stack.pop();
//                    continue;
//                }
                if(item - '0' >= 0 && item - '0'<= 9){
                    int last = j;
                    j--;
                    while (str.charAt(j) - '0' >= 0 && str.charAt(j) - '0'<= 9){
                        j--;
                    }
                    Integer num = Integer.valueOf(str.substring(j, last));
                    stack.push(num);
                }
            }
        }
    }
}
