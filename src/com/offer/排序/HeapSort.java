package com.offer.排序;

import java.util.Arrays;
import java.util.LinkedList;

public class HeapSort {
    public static void main(String []args){
        //int []arr = {7,6,7,11,5,12,3,0,1};
        int[] arr = {5, 3, 2, 8, 1, 7, 9, 4, 6, 10, 6, 0, 12};
        System.out.println("排序前："+ Arrays.toString(arr));
        heapSort(arr);
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            adjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjust(arr, 0, i);
        }
    }

    public static void adjust(int[] arr, int index, int len){
        int temp = arr[index];
        for (int i = index * 2 + 1; i < len; i = 2 * i + 1) {
            if(i + 1 < len && arr[i] < arr[i + 1]){
                i++;
            }
            if(arr[i] > temp){
                arr[index] = arr[i];
                index = i;
            }
        }
        arr[index] = temp;
    }






















    public static void sort(int []arr){
        //1.构建大顶堆
        for(int i = arr.length / 2 - 1; i >= 0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = arr.length - 1; j > 0; j--){
            swap(arr,0, j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0, j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k = i * 2 + 1; k < length; k = k * 2 + 1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1 < length && arr[k] < arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    public static void swap(int[] arr,int a ,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
