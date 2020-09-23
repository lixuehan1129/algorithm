package com.offer.a笔试.去哪儿;

import java.util.*;
public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        String[] strs = new String[m];
        for(int i = 0; i < m; i++){
            strs[i] = sc.next();
        }
        //一对 两对 三条
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            char ch = strs[i].charAt(1);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }

        }
        int countT = 0, countH = 0;
        for (Character character : map.keySet()) {
            if(map.get(character) == 4){
                System.out.println("SiTiao");
                return;
            }
            if(map.get(character) == 3){
                countH++;
            }
            if(map.get(character) == 2){
                countT++;
            }
        }
        if(countH > 1){
            System.out.println("HuLu");
            return;
        }
        if(countH == 1 && countT >= 1){
            System.out.println("HuLu");
            return;
        }
        if (countH == 1 && countT == 0){
            System.out.println("SanTiao");
            return;
        }
        if(countT > 1){
            System.out.println("LiangTiao");
            return;
        }
        if(countT == 1){
            System.out.println("YiDui");
        }

    }
}
