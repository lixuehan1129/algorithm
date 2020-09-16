package com.offer.a面试;

class Main {
    public static void main(String[] args) {
        System.out.println(re());
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(8);
        Node node2 = new Node(2);
        node2.next = new Node(8);

        Node pre1 = reverse(node1);
        Node pre2 = reverse(node2);

        Node newNode = new Node(-1);
        Node head = newNode;
        int carry = 0;
        while (pre1 != null || pre2 != null){
            int n1 = pre1 == null ? 0 : pre1.val;
            int n2 = pre2 == null ? 0 : pre2.val;
            int num = n1 + n2 + carry;
            carry = num / 10;
            newNode.next = new Node(num % 10);
            newNode = newNode.next;
            if(pre1 != null) pre1 = pre1.next;
            if(pre2 != null) pre2 = pre2.next;
        }

        Node pre = reverse(head.next);
        while(pre.next != null){
            System.out.print(pre.val + "->");
            pre = pre.next;
        }
        System.out.println(pre.val);
    }

    public static Node reverse(Node node){
        Node pre = null;
        Node cur = node;
        Node next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static int re(){
        try {
            return 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return 0;
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
