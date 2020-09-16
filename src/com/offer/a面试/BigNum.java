package com.offer.a面试;

import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        //System.out.println("Hello World!");
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(8);
        Node node2 = new Node(2);
        node2.next = new Node(8);

        ////
        Node pre1 = null;
        Node cur1 = node1;
        Node next1 = null;
        while(cur1 != null){
            next1 = cur1.next;
            cur1.next = pre1;
            pre1 = cur1;
            cur1 = next1;
        }

        Node pre2 = null;
        Node cur2 = node2;
        Node next2 = null;
        while(cur2 != null){
            next2 = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = next2;
        }

        Node newNode = new Node(-1);
        Node head = newNode;
        int carry = 0;
        while(pre1 != null && pre2 != null){
            int num = carry + pre1.val + pre2.val;
            carry = num / 10;
            num = num % 10;
            newNode.next = new Node(num);
            newNode = newNode.next;
            pre1 = pre1.next;
            pre2 = pre2.next;
        }
        while(pre1 != null){
            int num = carry + pre1.val;
            carry = num / 10;
            num = num % 10;
            newNode.next = new Node(num);
            newNode = newNode.next;
            pre1 = pre1.next;
        }
        while(pre2 != null){
            int num = carry + pre2.val;
            carry = num / 10;
            num = num % 10;
            newNode.next = new Node(num);
            newNode = newNode.next;
            pre2 = pre2.next;
        }


        Node pre = null;
        Node cur = head.next;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while(pre != null){
            System.out.print(pre.val + "->");
            pre = pre.next;
        }

    }
}
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}
