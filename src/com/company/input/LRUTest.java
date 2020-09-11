package com.company.input;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {
       LRUCache lruCache = new LRUCache(3);

    }
}
class LRUCache{
    private int capacity;
    private Map<Integer,Integer> cache;
    LinkedList<Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }
    //添加元素
    public void put(Integer key, Integer value){
        cache.put(key, value);
        if(!list.contains(key)){
            list.add(key);
        }
        afterPut(key, value);
    }
    //获取元素
    public int get(Integer key){
        if(cache.containsKey(key)){
            afterGet(key);
            return cache.get(key);
        }else{
            return -1;
        }
    }
    private void afterPut(Integer key, Integer value){
        if(cache.size() > capacity){
            Integer oldKey = list.getFirst();
            list.removeFirst();
            cache.remove(oldKey);
        }
    }
    private void afterGet(Integer key){
        list.removeFirst();
        list.addLast(key);
    }
}
