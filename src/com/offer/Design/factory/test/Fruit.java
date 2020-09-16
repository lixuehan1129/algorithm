package com.offer.Design.factory.test;

public interface Fruit {
    void showInfo();
}

class Apple implements Fruit{

    @Override
    public void showInfo() {
        System.out.println("苹果10元一个");
    }
}

class Mellon implements Fruit{

    @Override
    public void showInfo() {
        System.out.println("西瓜8元一半");
    }
}

