package com.offer.排序;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 8, 1, 7, 9, 4, 6, 10, 6, 0, 12};
        //mergeSort(arr, 0, arr.length - 1);
        //quickSort(arr, 0, arr.length - 1);
        heapSort(arr);
        System.out.println("排序" + Arrays.toString(arr));

    }


    public static void heapSort(int[] arr){
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len);
        }

        for (int i = len - 1; i > 0 ; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }

    public static void adjustHeap(int[] arr, int i, int length){
        int temp = arr[i];
        for(int k = 2 * i + 1; k < length; k = k * 2 + 1){
            if(k + 1 < length && arr[k] < arr[k + 1]){
                k++;
            }
            if(arr[k] > temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        arr[i] = temp;

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //快排
    public static void quickSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = partitionQuick(arr, left, right);
        quickSort(arr, left, mid - 1);
        quickSort(arr, mid + 1, right);
    }

    public static int partitionQuick(int[] arr, int left, int right){
        int p = arr[right];
        int l = left, r = right - 1;
        while (l <= r){
            if(arr[l] <= p) l++;
            if(l <= r && arr[r] > p) r--;

            if(l < r && arr[l] > p && arr[r] <= p) swap(arr, l, r);
        }
        swap(arr, l, right);
        return l;
    }

    //归并
    public static void mergeSort(int[] arr, int left, int right){
        if(left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        partitionMerge(arr, left, mid + 1, right);
    }

    public static void partitionMerge(int[] arr, int left, int mid, int right){
        int[] temp = new int[right - left + 1];
        int i = left, j = mid;
        int k = 0;
        while (i < mid && j <= right){
            temp[k++] = arr[i] >= arr[j] ? arr[j++] : arr[i++];
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        if (temp.length >= 0) System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
