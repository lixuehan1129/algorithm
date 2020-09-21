package com.offer.a笔试.好未来;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Permutation(s);
        in.close();
    }

    public static void Permutation(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        backTrace(ch, new boolean[str.length()], new StringBuilder(), 0);
    }

    public static void backTrace(char[] str, boolean[] path, StringBuilder sb, int depth){
        if(depth == str.length){
            System.out.println(sb.toString());
            return;
        }
        for(int i = 0; i < str.length; i++){
            if(path[i]) continue;
            if(i > 0 && str[i] == str[i - 1] && !path[i - 1]) continue;
            sb.append(str[i]);
            path[i] = true;
            backTrace(str, path, sb, depth + 1);
            sb.deleteCharAt(sb.length() - 1);
            path[i] = false;
        }
    }
}
