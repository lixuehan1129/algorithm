package com.offer.a笔试.OPPO;

import java.util.Scanner;
import java.util.Stack;
public class Main2 {
    public static void main(String[] args) {
        //输入要判断的字符串
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        //如果字符串长度为奇数则不匹配
        if(str.length() % 2 == 1){
            System.out.println("false");
            return;
        }
        //使用栈，左符号入栈，如果遍历到右符号，则从栈顶取出元素判断是否对应
        //如果对应则继续判断，不对应则返回false
        //遍历完，如果栈为空则返回true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{' || ch == '<'){
                stack.push(ch);
                continue;
            }
            if(ch == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    System.out.println("false");
                    return;
                }
            }
            if(ch == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    System.out.println("false");
                    return;
                }
            }
            if(ch == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    System.out.println("false");
                    return;
                }
            }
            if(ch == '>'){
                if(stack.isEmpty() || stack.pop() != '<'){
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
