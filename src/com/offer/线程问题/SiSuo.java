package com.offer.线程问题;

public class SiSuo {
    public static final String l1 = "lock1";
    public static final String l2 = "lock2";
    public static void main(String[] args) {
        Thread thread1 = new Thread(new lock1());
        Thread thread2 = new Thread(new lock2());
        thread1.start();
        thread2.start();

    }
}

class lock1 implements Runnable{

    @Override
    public void run() {
        synchronized (SiSuo.l1){
            System.out.println("1:l1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SiSuo.l2){
                System.out.println("1:l2");
            }
        }
    }
}

class lock2 implements Runnable{

    @Override
    public void run() {
        synchronized (SiSuo.l2){
            System.out.println("2:l2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (SiSuo.l1){
                System.out.println("2:l1");
            }
        }
    }
}

