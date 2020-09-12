package com.offer.a笔试.vivo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int pos = -1;
        boolean f1 = true, f2 = true;
        int low = 0;
        int high = s.length() - 1;
        while (low < high){
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else{
                int i = low + 1, j = high;
                pos = low;
                while (i < j){
                    if(s.charAt(i) != s.charAt(j)){
                        f1 = false;
                        break;
                    }
                    i++;
                    j--;
                }

                if(f1) break;

                i = low;
                j = high - 1;
                pos = high;
                while (i < j){
                    if(s.charAt(i) != s.charAt(j)){
                        f2 = false;
                        break;
                    }
                    i++;
                    j--;
                }

                if(!f2) break;

            }

        }
        if(!f1 && !f2){
            System.out.println("false");
        }else{
            for (int i = 0; i < s.length(); i++) {
                if(i == pos) continue;
                System.out.print(s.charAt(i));
            }
        }

    }
}
