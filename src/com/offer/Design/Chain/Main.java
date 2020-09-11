package com.offer.Design.Chain;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ChainManager chainManager = new ChainManager();
        chainManager.addTask(new Task1());
        chainManager.addTask(new Task2());
        chainManager.addTask(new Task3());
        chainManager.doAction("null", chainManager);
        //HashMap
    }
}
