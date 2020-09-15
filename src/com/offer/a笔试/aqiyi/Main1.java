package com.offer.a笔试.aqiyi;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 0);
        map.put(10, 0);
        map.put(20, 0);
        while (sc.hasNext()){
            int num = sc.nextInt();
            if(num == 5){
                map.put(5, map.get(5) + 1);
            }else if(num == 10){
                if(map.get(5) > 0){
                    map.put(10, map.get(10) + 1);
                    map.put(5, map.get(5) - 1);
                }else{
                    System.out.println("false");
                    break;
                }
            }else if(num == 20){
                if(map.get(10) > 0 && map.get(5) > 0){
                    map.put(20, map.get(20) + 1);
                    map.put(10, map.get(10) - 1);
                    map.put(5, map.get(5) - 1);
                }else if(map.get(10) == 0 && map.get(5) >= 3){
                    map.put(20, map.get(20) + 1);
                    map.put(5, map.get(5) - 3);
                }else{
                    System.out.println("false");
                    break;
                }
            }
        }
        System.out.println("true");
    }
}
