package com.offer;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //String s = "google";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int max = 0;
        for(int i = 1; i < len; i++){
            int length = check(s, i);
            //System.out.println(length);
            max = Math.max(length, max);
        }
        System.out.println(max);
    }

    public static int check(String s, int index){
        int left = index;
        int right = index;
        int maxLen = 0;
        while (left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        maxLen = right - left - 1;
        //
        left = index;
        right = index + 1;
        while (left >= 0 && right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        maxLen = Math.max(maxLen, right - left - 1);
        return maxLen;
    }
}
