package com.offer.线程问题;

public class ProRe {
    private final static Object o = new Object();
    private int count = 0;
    private final int LENGTH = 10;
    public static void main(String[] args) {
        ProRe proRe = new ProRe();
        for (int i = 0; i < 6; i++) {
            new Thread(proRe.new Producer()).start();
            new Thread(proRe.new Consumer()).start();
        }
    }

    class Producer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o){
                    while (count == LENGTH){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("pro");
                    o.notifyAll();
                }

            }
        }
    }

    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o){
                    while (count <= 0){
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("con");
                    o.notifyAll();
                }

            }
        }
    }
}
