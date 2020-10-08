package com.offer.排序;

import java.util.Arrays;
import java.util.HashMap;

public class ReMember {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 1, 7, 9, 4, 6, 10, 6, 0, 12};
        //quickSort(arr, 0, arr.length - 1);
        //mergeSort(arr, 0, arr.length - 1);
        //heapSort(arr);
        //bubbleSort(arr);
        //selectSort(arr);
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            int temp = arr[j];
            for(; j > 0 && temp < arr[j - 1]; j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void selectSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int pos = i;
            for (int j = i + 1; j < len; j++) {
                pos = arr[pos] < arr[j] ? pos : j;
            }
            swap(arr, i, pos);
        }
    }
    public static void bubbleSort(int[] arr){
        int len = arr.length;
        for(int i = len - 1; i > 0; i--){
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[i]) swap(arr, j, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort(int[] arr){
        int len = arr.length;
        for(int i = len / 2 - 1; i >= 0; i--){
            adjustHeap(arr, i, len);
        }
        for(int i = len - 1; i >= 0; i--){
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int index, int len){
        int temp = arr[index];
        for(int i = 2 * index + 1; i < len; i++){
            if(i + 1 < len && arr[i] < arr[i + 1]) i++;
            if(temp < arr[i]){
                arr[index] = arr[i];
                index = i;
            }else {
                break;
            }
        }
        arr[index] = temp;
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        partitionMerge(arr, left, mid + 1, right);
    }

    public static void partitionMerge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int l = left, m = mid;
        int k = 0;
        while (l < mid && m <= right){
            if(arr[l] < arr[m]){
                temp[k++] = arr[l];
                l++;
            }else {
                temp[k++] = arr[m];
                m++;
            }
        }
        while (l < mid) temp[k++] = arr[l++];
        while (m <= right) temp[k++] = arr[m++];
        for(int i = 0; i < k; i++) arr[left + i] = temp[i];
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = partitionQuick(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    public static int partitionQuick(int[] arr, int left, int right){
        int num = arr[right];
        int l = left, r = right - 1;
        while (l <= r){
            if(arr[l] < num) l++;
            if(l <= r && arr[r] >= num) r--;
            if(l < r && arr[l] >= num && arr[r] < num) swap(arr, l, r);
        }
        swap(arr, l, right);
        return l;
    }
}
