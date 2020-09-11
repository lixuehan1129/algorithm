package com.offer.递归;

/**
 * 皇后问题
 */
public class Main {
    public static void main(String[] args) {
        te03();
    }

    /**
     * 8皇后
     */
    public static void te03(){
        System.out.println(num1(8));
    }

    public static int num1(int n){
        if(n < 1) return 0;
        //record[i] 表示第i行的所在的列
        int[] record = new int[n];
        return process(0, record, n);

    }
    public static int process(int i, int[] record, int n){
        if(i == n) return 1;
        int res = 0;
        for(int j = 0; j < n; j++){
            if(check(record, i, j)){
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }
    public static boolean check(int[] record, int i, int j){
        for(int k = 0; k < i; k++){
            if(record[k] == j || Math.abs(i - k) == Math.abs(record[k] - j)) return false;
        }
        return true;
    }
}
