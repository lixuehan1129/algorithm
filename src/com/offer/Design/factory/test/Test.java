package com.offer.Design.factory.test;

public class Test {
    public static void main(String[] args) {
        Apple apple = (Apple) new AppleShop().saleFruit();
        apple.showInfo();
        Mellon mellon = (Mellon) new MellonShop().saleFruit();
        mellon.showInfo();
    }
}
