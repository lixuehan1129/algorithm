package com.offer.链表;

import java.util.Stack;

public class ReverseList {
}

class Solution {
    //链表范围反转
    class 链表范围反转{
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m == 1){
                return reverse(head, n);
            }
            head.next = reverseBetween(head.next, m - 1, n - 1);
            return head;

        }
        ListNode tail = null;
        public ListNode reverse(ListNode head, int n){
            if(n == 1){
                tail = head.next;
                return head;
            }
            ListNode last = reverse(head.next, n - 1);
            head.next.next = head;
            head.next = tail;
            return last;
        }

    }

    class k个一组反转{
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null || k < 2) return head;
        /*
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = reverse(stack, pre, next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;*/
            ListNode cur = head;
            ListNode start = null;
            ListNode pre = null;
            ListNode next = null;
            int count = 1;
            while(cur != null){
                next = cur.next;
                if(count % k == 0){
                    start = pre == null ? head : pre.next;
                    head = pre == null ? cur : head;
                    reverse(pre, start, cur, next);
                    pre = start;
                }
                count++;
                cur = next;
            }
            return head;
        }

        public void reverse(ListNode left, ListNode start, ListNode end, ListNode right){
            ListNode pre = start;
            ListNode cur = start.next;
            ListNode next = null;
            while(cur != right){
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            if(left != null){
                left.next = end;
            }
            start.next = right;
        }

        public ListNode reverse(Stack<ListNode> stack, ListNode left, ListNode right){
            ListNode cur = stack.pop();
            if(left != null){
                left.next = cur;
            }
            ListNode next = null;
            while(!stack.isEmpty()){
                next = stack.pop();
                cur.next = next;
                cur = next;
            }
            cur.next = right;
            return cur;
        }
    }

    class 多个合并{
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;
            return merge(lists, 0, lists.length - 1);
        }
        public ListNode merge(ListNode[] lists, int left, int right){
            if(left == right) return lists[left];
            if(left > right) return null;
            int mid = left + (right - left) / 2;
            return mergeTwoKLists(merge(lists, left, mid), merge(lists, mid + 1, right));
        }

        public ListNode mergeTwoKLists(ListNode l1, ListNode l2){
            ListNode head = new ListNode(0);
            ListNode res = head;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    res.next = l1;
                    l1 = l1.next;
                }else{
                    res.next = l2;
                    l2 = l2.next;
                }
                res = res.next;
            }
            res.next = l1 == null ? l2 : l1;
            return head.next;
        }
    }

    class 矩阵旋转{
        public void rotate(int[][] matrix) {
            if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
            int colT = 0, colB = matrix.length - 1, rowL = 0, rowR = matrix[0].length - 1;
            while(colT <= colB && rowL <= rowR){
                rotateEdge(matrix, colT++, colB--, rowL++, rowR--);
            }
        }

        public void rotateEdge(int[][] matrix, int colT, int colB, int rowL, int rowR){
            int bound = colB - colT;
            for(int i = 0; i < bound; i++){
                int tmp = matrix[colT][rowL + i];
                matrix[colT][rowL + i] = matrix[colB - i][rowL];
                matrix[colB - i][rowL] = matrix[colB][rowR - i];
                matrix[colB][rowR - i] = matrix[colT + i][rowR];
                matrix[colT + i][rowR] = tmp;
            }
        }
    }

    class 跳跃游戏{
        public int jump(int[] nums) {
            if(nums == null || nums.length == 0) return 0;
            int jump = 0;
            int cur = 0;
            int next = 0;
            for(int i = 0; i < nums.length; i++){
                if(i > cur){
                    jump++;
                    cur = next;
                }
                next = Math.max(next, i + nums[i]);
            }
            return jump;
        }
    }

}

/**
 * Definition for singly-linked list.*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


