package com.offer.线程问题;

import java.util.concurrent.*;

public class E_线程池 {
    public static void main(String[] args) {

        ExecutorService executor = new ThreadPoolExecutor(2,
                5,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 20; i++) {
            try{
                executor.execute(new Task(i));
            }catch (Throwable throwable){
                System.out.println("丢弃" + i);
            }

        }
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        queue.put(i);
                        System.out.println("装入" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("取出" + queue.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    static class Task implements Runnable{
        int i;
        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println("第" + i + "号线程");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(i + "执行完毕");
        }
    }
}
