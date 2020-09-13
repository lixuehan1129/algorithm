package com.offer.a笔试.aqiyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int three = sc.nextInt();
        TaskManager taskManager = new TaskManager();
        new Thread(()->{
            try {
                taskManager.task1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                taskManager.task2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                taskManager.task3();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

    }
}

class TaskManager {
    private boolean first;
    private boolean second;
    private Object lock = new Object();
    TaskManager(){
    }

    public void task1() throws Exception{
        synchronized (lock){
            System.out.print("task1");
            first = true;
            lock.notifyAll();
        }
    }
    public void task2 () throws Exception{
        synchronized (lock){
            while (!first){
                lock.wait();
            }
            System.out.print("task2");
            second = true;
            lock.notifyAll();
        }
    }
    public void task3 () throws Exception{
        synchronized (lock){
            while (!second){
                lock.wait();
            }
            System.out.println("task3");
        }
    }

}
