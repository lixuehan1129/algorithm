package com.offer.a面试;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class NumK {
    public static void main(String[] args) {
        System.out.println(findKth(new int[] {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,
                1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,
                1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,
                1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663}, 49, 24));
    }
//    public static int findKth(int[] a, int n, int K) {
//        // write code here
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
//        for(int i = 0; i < n; i++){
//            queue.offer(a[i]);
//            if(queue.size() > K){
//                queue.poll();
//            }
//        }
//
//        return queue.peek();
//
//    }


    public static int findKth(int[] a, int n, int K) {
        // write code here
        /*
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            queue.offer(a[i]);
            if(queue.size() > K){
                queue.poll();
            }
        }

        return queue.peek();*/

        return findK(a, 0, n - 1, K);
    }

    public static int findK(int[] a, int left, int right, int K){
        if(left <= right){
            int index = partition(a, left, right);
            if(index == K - 1){
                return a[index];
            }else if(index < K - 1){
                return findK(a, index + 1, right, K);
            }else{
                return findK(a, left, index - 1, K);
            }
        }
        return -1;
    }

    public static int partition(int[] a, int leftBound, int rightBound){
        int pivot = a[rightBound];
        int left = leftBound, right = rightBound - 1;
        while(left <= right){
            if(a[left] >= pivot) left++;
            if(left <= right && a[right] <= pivot) right--;
            if(left < right && a[left] < pivot && a[right] > pivot) swap(a, left, right);
        }
        swap(a, rightBound, left);
        return left;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
