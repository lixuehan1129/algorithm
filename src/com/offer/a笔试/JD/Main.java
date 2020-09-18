package com.offer.a笔试.JD;

import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        List<Integer> res = new ArrayList<>();
//        String input = in.nextLine();
//        in.close();
//        int count=0;
//        for(int i=0;i<input.length();i++){
//            if(input.charAt(i)>='0' && input.charAt(i)<='9'){
//                if(count==0 && input.charAt(i)=='0'){
//                    continue;
//                }else{
//                    count++;
//                }
//            }else{
//                if(count==4){
//                    res.add(Integer.parseInt(input.substring(i-count,i)));
//                }
//                count = 0;
//            }
//        }
//        if(count==4){
//            res.add(Integer.parseInt(input.substring(input.length()-count,input.length())));
//        }
//        boolean first= true;
//        for(Integer s:res){
//            if(s<=3999 && s>=1000){
//                if(first){
//                    System.out.print(s);
//                    first=false;
//                }else{
//                    System.out.print(" "+s);
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int i = 0;
        while (i < len - 3){
            StringBuilder sb = new StringBuilder();
            if(str.charAt(i) - '0' >= 1 && str.charAt(i) - '0' < 4){
                sb.append(str.charAt(i));
                int j = i + 1;
                while (j < len && str.charAt(j) - '0' >= 0 && str.charAt(j) - '0' <= 9){
                    sb.append(str.charAt(j));
                    j++;
                }
                i = j - 1;
            }
            if(sb.length() == 4) System.out.print(sb.toString() + " ");
            i++;
        }
    }
}
