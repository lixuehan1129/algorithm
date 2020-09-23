package com.offer.LRU;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUTest {
    public static void main(String[] args) {
       LRUCache lruCache = new LRUCache(3);

    }
}
class LRUCache{
    static class Node{
        int key, value;
        Node pre, next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Map<Integer, Node> map;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        head.next = tail;
        tail.pre = head;
    }

    public void set(int key, int value){
        //判断是否存在。如果存在将节点放到头部
        if(get(key) != -1){
            map.get(key).value = value;
        }else{
            //更新第三个节点头部信息，将第二个节点信息替换为第三个节点
            if(map.size() == capacity){
                int headKey = head.next.key;
                head.next.next.pre = head;
                head.next = head.next.next;
                map.remove(headKey);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            toTail(node);
        }
    }

    public int get(int key){
        if(map.containsKey(key)){
            //取出该结点
            Node node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            toTail(node);
            return node.value;
        }
        return -1;
    }

    //将节点放置到尾部
    public void toTail(Node node){
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }
}

class LRUCacheLinked{
    private int capacity;
    private Map<Integer,Integer> cache;
    LinkedList<Integer> list;

    public LRUCacheLinked(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.list = new LinkedList<>();
    }
    //添加元素
    public void put(Integer key, Integer value){
        get(key);
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
